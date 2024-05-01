//Función para guardar datos
function save() {
    try {
        var selectedDepartment = parseInt($("#selected_departament").val());
        if (inNaN(selectedDepartment) || selectedDepartment == null) {
            console.error("Error con ciudad.");
            return;
        }
        var data = {
            'name': $('#name').val(),
            'department': { 'id': selectedDepartment },
            'state': parseInt($('#state').val())
        };
        var jsonData = JSON.stringify(data);
        $.ajax({
            url: '',
            method: 'GET',
            dataType: 'json',
            contentType: 'aplication/json',
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
        var selectedDepartment = parseInt($("#selected_departament").val());
        if (inNaN(selectedDepartment) || selectedDepartment == null) {
            console.error("Error con ciudad.");
            return;
        }
        var data = {
            'name': $('#name').val(),
            'department': { 'id': selectedDepartment },
            'state': parseInt($('#state').val())
        };
        var id = parseInt($('#id').val());
        var jsonData = JSON.stringify(data);
        $.ajax({
            url: '' + id,
            method: 'PUT',
            dataType: 'json',
            contentType: 'aplication/json',
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
        url: '' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            $('#id').val(data.data.id);
            $('#name').val(data.data.name);
            $('#department').val(data.data.department.name);
            $('#state').val(data.data.state === true ? 1 : 0);

            var btnAgregar = $('button[name="btnAgegar"]');
            btnAgregar.text('Actualizar');
            btnAgregar.attr('onclick', 'update()');
        },
        error: function (error) {
            console.error('Error: ', error);
        }
    });
}

//Función para eliminar datos de manera permanente
function dropById(id) {
    $.ajax({
        url: '' + id,
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
    $('#name').val('');
    $('#state').val('');
}

//Función para mostrar los datos en una tabla
function loadData() {
    $.ajax({
        url: '',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            var html = '';
            var data = response.data;
            if (Array.isArray(data)) {
                data.forEach(function (item) {
                    html +=
                    `<tr>
                    <td>${item.code}</td>
                    <td>${item.name}</td>
                    <td>${item.email}</td>
                    <td>${item.country.name}</td>
                    <td>${item.state === true ? '' : ''}</td>
                    <td><button class="btn btn-warning" data-bs-toggle="modal" onclick='findById(${item.id})'><img href='../assets/icon/pencil-square.svg'></button></td>
                    <td><button class="btn btn-danger" onclick='dropById(${item.id})'><img href='../assets/icon/trash3-fill.svg'></button></td>
                    <td><button class="btn btn-secundary" onclick='deleteById(${item.id})'><img href='../assets/icon/eye-slash-fill.svg'></button></td>
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
    return loadDepartment();
}

//Autocomplete 
function loadDepartment() {
    $.ajax({
        url: '',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            if (response.status && Array.isArray(response.data)) {
                var depa = response.data.map(function (depart) {
                    return {
                        label: depart.name,
                        value: depart.id
                    };
                });
                $('#department').autocomplete({
                    source: function (request, response) {
                        var results = $.ui.autocomplete.filter(depa, request.term);
                        if (!result.length) {
                            results = [{ label: 'No hay datos', value: null }];
                        }
                        respose(results);
                    },
                    select: function (even, ui) {
                        $('#selected_department').val(ui.item.value);
                        $('#department').val(ui.item.label);
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