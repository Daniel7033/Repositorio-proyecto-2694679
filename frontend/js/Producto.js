//Función para guardar datos
function save() {
    try {
        var selectedInsumo = parseInt($("#selected_insumo").val());
        if (isNaN(selectedInsumo) || selectedInsumo == null) {
            console.error("Error con ciudad.");
            return;
        }
        var data = {
            'name': $('#name').val(),
            'precio': parseFloat($('#precio').val()),
            'descuento': parseInt($('#descuento').val()),
            'iva': parseInt($('#iva').val()),
            //'insumo': [{ 'id': selectedInsumo }],
            'shortDescription': $('#shortDescription').val(),
            'longDescription': $('#longDescription').val(),
            'state': parseInt($('#state').val())
        };
        var jsonData = JSON.stringify(data);
        $.ajax({
            url: 'http://localhost:7033/security/v1/api/producto',
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
        var selectedInsumo = parseInt($("#selected_insumo").val());
        if (isNaN(selectedInsumo) || selectedInsumo == null) {
            console.error("Error con ciudad.");
            return;
        }
        var data = {
            'name': $('#name').val(),
            'precio': parseFloat($('#precio').val()),
            'descuento': parseInt($('#descuento').val()),
            'iva': parseInt($('#iva').val()),
            //'insumo': [{ 'id': selectedInsumo }],
            'shortDescription': $('#shortDescription').val(),
            'longDescription': $('#longDescription').val(),
            'state': parseInt($('#state').val())
        };
        var id = parseInt($('#id').val());
        var jsonData = JSON.stringify(data);
        $.ajax({
            url: 'http://localhost:7033/security/v1/api/producto/' + id,
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
        url: 'http://localhost:7033/security/v1/api/producto/' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data){
            $('#id').val(data.data.id);
            $('#name').val(data.data.name);
            $('#precio').val(data.data.precio);
            $('#descuento').val(data.data.descuento);
            $('#iva').val(data.data.iva);
            //$('#insumo').val(data.data.insumo.name);
            $('#shortDescription').val(data.data.shortDescription);
            $('#longDescription').val(data.data.longDescription);
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
        url: 'http://localhost:7033/security/v1/api/producto/' + id,
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
    $('#precio').val('');
    $('#descuento').val('');
    $('#iva').val('');
    $('#shortDescription').val('');
    $('#longDescription').val('');
    //$('#insumo').val('');
    $('#state').val('');
}

//Función para mostrar los datos en una tabla
function loadData() {
    $.ajax({
        url: 'http://localhost:7033/security/v1/api/producto',
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
                    <td>${item.shortDescription}</td>
                    <td>${item.longDescription}</td>
                    <td>$${item.precio}.00</td>
                    <td>${item.descuento}%</td>
                    <td>${item.iva}%</td>
                    <td>$${item.costoPrecio}</td>
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
    return loadInsumo();
}

//Autocomplete 
function loadInsumo() {
    $.ajax({
        url: 'http://localhost:7033/security/v1/api/insumo',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            if (response.status && Array.isArray(response.data)) {
                var insumos = response.data.map(function (insumo) {
                    return {
                        label: `${insumo.name} (${insumo.code})`,
                        value: insumo.id
                    };
                });
                $('#insumo').autocomplete({
                    source: function (request, response) {
                        var results = $.ui.autocomplete.filter(insumos, request.term);
                        if (!results.length) {
                            results = [{ label: 'No hay datos', value: null }];
                        }
                        response(results);
                    },
                    select: function (even, ui) {
                        $('#selected_insumo').val(ui.item.value);
                        $('#insumo').val(ui.item.label);
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