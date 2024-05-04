//Función para retornar todos los enums/datos quemados
function enums() {
    return loadType(), loadGender(), loadAddress();
}

//Funiones enums/datos quemados
function loadType() {
    $.ajax({
        url: 'http://localhost:7033/security/v1/api/enum/typeDocument',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            var html = "";
            response.forEach(function (item) {
                html += `<option value="${item}">${item}</option>`
            });
            $("#typeDocument").html(html);
        },
        error: function (error) {
            console.error("Error: ", error);
        },
    });
}
function loadGender() {
    $.ajax({
        url: 'http://localhost:7033/security/v1/api/enum/genero',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            var html = "";
            response.forEach(function (item) {
                html += `<option value="${item}">${item}</option>`;
            });
            $("#gender").html(html);
        },
        error: function (error) {
            console.error("Error: ", error);
        }
    });
}
function loadAddress() {
    $.ajax({
        url: 'http://localhost:7033/security/v1/api/enum/nomenclatura',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            var html = "";
            response.forEach(function (item) {
                html += `<option value="${item}">${item}</option>`;
            });
            $('#address').html(html);
        },
        error: function (error) {
            console.error("Error: ", error);
        }
    });
}

//Función para guardar datos
function save() {
    try {
        var selectedCity = parseInt($("#selected_city").val());
        if (isNaN(selectedCity) || selectedCity == null) {
            console.error("Error con ciudad.");
            return;
        }
        var data = {
            'typeDocument': $('#typeDocument').val(),
            'document': parseInt($('#document').val()),
            'firstName': $('#firstName').val(),
            'lastName': $('#lastName').val(),
            'dateOfBitrth': parseInt($('#dateOfBitrth').val()),
            'gender': $('#gender').val(),
            'email': $('#email').val() + $('#mail').val(),
            'phone': parseInt($('#phone').val()),
            'city': { 'id': selectedCity },
            'address': $('#address').val() + ' No. ' + $('#numeral').val() + ' - ' + $('#numeral2').val() + '. ' + $('#description').val(),
            'state': parseInt($('#state').val())
        };
        var jsonData = JSON.stringify(data);
        $.ajax({
            url: 'http://localhost:7033/security/v1/api/person',
            method: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: jsonData,
            success: function (data) {
                alert("Guardado");
                loadData();
                clearData();
            },
            error: function (error) {
                console.error("Error: ", error);
            }
        });
    } catch (error) {
        console.error("Error: ", error);
    }
}

//Función para actualizar datos
function update() {
    try {
        var selectedCity = parseInt($("#selected_city").val());
        if (isNaN(selectedCity) || selectedCity == null) {
            console.error("Error con ciudad.");
            return;
        }
        var data = {
            'typeDocument': $('#typeDocument').val(),
            'document': parseInt($('#document').val()),
            'firstName': $('#firstName').val(),
            'lastName': $('#lastName').val(),
            'dateOfBitrth': parseInt($('#dateOfBitrth').val()),
            'gender': $('#gender').val(),
            'email': $('#email').val() + $('#mail').val(),
            'phone': parseInt($('#phone').val()),
            'city': { 'id': selectedCity },
            'address': $('#address').val() + ' No. ' + $('#numeral').val() + ' - ' + $('#numeral2').val() + '. ' + $('#description').val(),
            'state': parseInt($('#state').val())
        };
        var id = parseInt($('#id').val());
        var jsonData = JSON.stringify(data);
        $.ajax({
            url: 'http://localhost:7033/security/v1/api/person/' + id,
            method: 'PUT',
            dataType: 'json',
            contentType: 'application/json',
            data: jsonData,
            success: function (result) {
                alert("Actualizado");
                loadData();
                clearData();

                var btnAgregar = $('button[name="btnAgregar"]');
                btnAgregar.text('Guardar');
                btnAgregar.attr('onclick', 'save()');
            },
            error: function (error) {
                console.error("Error: ", error);
            }
        });
    } catch (error) {
        console.error("Error: ", error);
    }
}

//Función para buscar datos por "id"
function findById(id) {
    $.ajax({
        url: 'http://localhost:7033/security/v1/api/person/' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data){
            $('#id').val(data.data.id);
            $('#typeDocument').val(data.data.typeDocument);
            $('#document').val(data.data.document);
            $('#firstName').val(data.data.firstName);
            $('#lastName').val(data.data.lastName);
            $('#dateOfBitrth').val(data.data.dateOfBitrth);
            $('#gender').val(data.data.gender);
            $('#email').val(data.data.email);
            $('#phone').val(data.data.phone);
            $('#city').val(data.data.city.name);
            $('#address').val(data.data.address);
            $('#state').val(data.data.state === true ? 1 : 0);

            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text('Actualizar');
            btnAgregar.attr('onclick', 'update()');
        },
        error: function (error){
            console.error('Error: ', error);
        }
    });
}

//Función para eliminar datos de manera permanente
function dropById(id) {
    $.ajax({
        url: 'http://localhost:7033/security/v1/api/person/' + id,
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (result) {
        alert("Registro eliminado exitoso");
        loadData();
        clearData();
    }).fail(function (xhr, status, error) {
        console.error("Error al eliminar el registro:", error);
    });
}

//Función para eliminar datos de manera lógica
function deleteById(id) {

}

//Función para limpiar datos
function clearData() {
    $('#typeDocument').val('');
    $('#document').val('');
    $('#firstName').val('');
    $('#lastName').val('');
    $('#dateOfBitrth').val('');
    $('#gender').val('');
    $('#email').val('');
    $('#phone').val('');
    $('#city').val('');
    $('#address').val('');
    $('#state').val('');
}

//Función para mostrar los datos en una tabla
function loadData() {
    $.ajax({
        url: 'http://localhost:7033/security/v1/api/person',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            var html = '';
            var data = response.data;
            if (Array.isArray(data)) {
                data.forEach(function (item) {
                    html +=
                        `<tr>
                    <td>${item.typeDocument} - ${item.document}</td>
                    <td>${item.firstName} ${item.lastName}</td>
                    <td>${item.gender}</td>
                    <td>${item.dateOfBitrth}</td>
                    <td>${item.email}</td>
                    <td>${item.phone}</td>
                    <td>${item.address}. ${item.city.name} (${item.city.department.name})</td>
                    <td>${item.state === true ? '<img src="../assets/icon/circle-true.png">' : '<img src="../assets/icon/circle-false.png">'}</td>
                    <td><button class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick='findById(${item.id})'><img src='../assets/icon/pencil-square.svg'></button></td>
                    <td><button class="btn btn-danger" onclick='dropById(${item.id})'><img src='../assets/icon/trash3-fill.svg'></button></td>
                    <td><button class="btn btn-secondary" onclick='deleteById(${item.id})'><img src='../assets/icon/eye-slash-fill.svg'></button></td>
                </tr>`
                });
            } else {
                console.error('Error.');
            }
            $('#resultData').html(html);
        },
        error: function (error) {
            console.error('Error: ', error);
        }
    });
}

//Función para retornar datos del autocomplete
function autocomplete() {
    return loadCity();
}

//Autocomplete 
function loadCity() {
    $.ajax({
        url: 'http://localhost:7033/security/v1/api/city',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            if (response.status && Array.isArray(response.data)) {
                var cities = response.data.map(function (city) {
                    return {
                        label: `${city.name} (${city.department.country.name})`,
                        value: city.id
                    };
                });
                $('#city').autocomplete({
                    source: function (request, response) {
                        var results = $.ui.autocomplete.filter(cities, request.term);
                        if (!results.length) {
                            results = [{ label: 'No hay datos', value: null }];
                        }
                        response(results);
                    },
                    select: function (even, ui) {
                        $('#selected_city').val(ui.item.value);
                        $('#city').val(ui.item.label);
                        console.log('ID seleccionado', ui.item.value);
                        return false;
                    }
                });
            } else {
                console.error('Error.');

            }
        },
        error: function (error) {
            console.error('Error: ', error);
        }
    });
}