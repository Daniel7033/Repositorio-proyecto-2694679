//Función para guardar datos
function save() {
    try {
        var data = {
            'name': $('#name').val(),
            'state': $('#state').val() == 1 ? true : false
        };
        var jsonData = JSON.stringify(data);
        $.ajax({
            url: 'http://localhost:7033/security/v1/api/country',
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
        var data = {
            'name': $('#name').val(),
            'state': parseInt($('#state').val())
        };
        var id = parseInt($('#id').val());
        var jsonData = JSON.stringify(data);
        $.ajax({
            url: 'http://localhost:7033/security/v1/api/country/' + id,
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
        url: 'http://localhost:7033/security/v1/api/country/' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            $('#id').val(data.data.id);
            $('#name').val(data.data.name);
            $('#state').val(data.data.state === true ? 1 : 0);

            var btnAgregar = $('button[name="btnAgregar"]');
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
        url: 'http://localhost:7033/security/v1/api/country/' + id,
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
        url: 'http://localhost:7033/security/v1/api/country',
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

//Metodo de filtrado
function filtrar(){ //filtrar todos los datos
    var criteria = {};
    var inputs = $('#data input');
    inputs.each(function() {
        var key = $(this).data('column');
        var value = $(this).val();
        if (value) {
            criteria[key] = value;
        }
    });
    $.ajax({
        url: 'http://localhost:7033/security/v1/api/country/filtrar/',
        method: "GET",
        data: criteria,
        dataType: 'json',
        success: function (response) {
            var html = '';
            var data = response.data;
            if (Array.isArray(data)) {
                data.forEach(function (item) {
                    html += loadData(item);
                });
            }
            $('#resultData').html(html);
        },
        error: function (error) {
            console.error('Error: ', error);
        }
    });
}
function filtrarEstado(){ //filtrar por estado
    var dato = ($('#state').val());
    $.ajax({
        url: 'http://localhost:7033/security/v1/api/country/filtrar/' + dato,
        method: "GET",
        dataType: 'json',
        success: function (response) {
            var html = '';
            var data = response.data;
            if (Array.isArray(data)) {
                data.forEach(function (item) {
                    html += loadData(item);
                });
            }
            $('#resultData').html(html);
        },
        error: function (error) {
            console.error('Error: ', error);
        }
    });
}