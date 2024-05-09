//Función para guardar datos
function save() {
    try {
        var selectedProducto = parseInt($("#selected_producto").val());
        if (isNaN(selectedProducto) || selectedProducto == null) {
            console.error("Error con ciudad.");
            return;
        }
        var selectedFactura = parseInt($("#selected_factura").val());
        if (isNaN(selectedFactura) || selectedFactura == null) {
            console.error("Error con ciudad.");
            return;
        }
        var data = {
            'factura': { 'id': selectedFactura },
            'producto': { 'id': selectedProducto },
            'cantidad': parseInt($('#cantidad').val()),
            'state': parseInt($('#state').val())
        };
        var jsonData = JSON.stringify(data);
        $.ajax({
            url: 'http://localhost:7033/security/v1/api/factura_detalle',
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
        var selectedProducto = parseInt($("#selected_producto").val());
        if (isNaN(selectedProducto) || selectedProducto == null) {
            console.error("Error con ciudad.");
            return;
        }
        var selectedFactura = parseInt($("#selected_factura").val());
        if (isNaN(selectedFactura) || selectedFactura == null) {
            console.error("Error con ciudad.");
            return;
        }
        var data = {
            'factura': { 'id': selectedFactura },
            'producto': { 'id': selectedProducto },
            'cantidad': parseInt($('#cantidad').val()),
            'state': parseInt($('#state').val())
        };
        var id = parseInt($('#id').val());
        var jsonData = JSON.stringify(data);
        $.ajax({
            url: 'http://localhost:7033/security/v1/api/factura_detalle/' + id,
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
        url: 'http://localhost:7033/security/v1/api/factura_detalle/' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data){
            $('#id').val(data.data.id);
            $('#factura').val(data.data.factura.code);
            $('#producto').val(data.data.producto.name);
            $('#cantidad').val(data.data.cantidad);
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
        url: 'http://localhost:7033/security/v1/api/factura_detalle/' + id,
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
    $('#factura').val('');
    $('#producto').val('');
    $('#cantidad').val('');
    $('#state').val('');
}

//Función para mostrar los datos en una tabla
function loadData() {
    $.ajax({
        url: 'http://localhost:7033/security/v1/api/factura_detalle',
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
                    <td>${item.factura.code}</td>
                    <td>${item.producto.name}</td>
                    <td>${item.cantidad}</td>
                    <td>${item.producto.precio}</td>
                    <td>${item.subTotal}</td>
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
    return loadProducto(), loadFactura();
}

//Autocomplete 
function loadProducto() {
    $.ajax({
        url: 'http://localhost:7033/security/v1/api/producto',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            if (response.status && Array.isArray(response.data)) {
                var productos = response.data.map(function (producto) {
                    return {
                        label: `${producto.name}: ${producto.code}`,
                        value: producto.id
                    };
                });
                $('#producto').autocomplete({
                    source: function (request, response) {
                        var results = $.ui.autocomplete.filter(productos, request.term);
                        if (!results.length) {
                            results = [{ label: 'No hay datos', value: null }];
                        }
                        response(results);
                    },
                    select: function (even, ui) {
                        $('#selected_producto').val(ui.item.value);
                        $('#producto').val(ui.item.label);
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
function loadFactura() {
    $.ajax({
        url: 'http://localhost:7033/security/v1/api/factura',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            if (response.status && Array.isArray(response.data)) {
                var facturas = response.data.map(function (factura) {
                    return {
                        label: `${factura.code} `,
                        value: factura.id
                    };
                });
                $('#factura').autocomplete({
                    source: function (request, response) {
                        var results = $.ui.autocomplete.filter(facturas, request.term);
                        if (!results.length) {
                            results = [{ label: 'No hay datos', value: null }];
                        }
                        response(results);
                    },
                    select: function (even, ui) {
                        $('#selected_factura').val(ui.item.value);
                        $('#factura').val(ui.item.label);
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