//Función para guardar datos
function save() {
    try {
        var selectedPerson = parseInt($("#selected_person").val());
        if (inNaN(selectedPerson) || selectedPerson == null) {
            console.error("Error con ciudad.");
            return;
        }
        var selectedRole = parseInt($("#selected_role").val());
        if (inNaN(selectedRole) || selectedRole == null) {
            console.error("Error con ciudad.");
            return;
        }
        var data = {
            'username': $('#username').val(),
            'password': $('#password').val(),
            'person': { 'id': selectedPerson },
            'role': { 'id': selectedRole },
            'state': parseInt($('#state').val())
        };
        var jsonData = JSON.stringify(data);
        $.ajax({
            url: 'http://localhost:7033/security/v1/api/user',
            method: 'POST',
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
        var selectedPerson = parseInt($("#selected_person").val());
        if (inNaN(selectedPerson) || selectedPerson == null) {
            console.error("Error con ciudad.");
            return;
        }
        var selectedRole = parseInt($("#selected_role").val());
        if (inNaN(selectedRole) || selectedRole == null) {
            console.error("Error con ciudad.");
            return;
        }
        var data = {
            'username': $('#username').val(),
            'password': $('#password').val(),
            'person': { 'id': selectedPerson },
            'role': { 'id': selectedRole },
            'state': parseInt($('#state').val())
        };
        var id = parseInt($('#id').val());
        var jsonData = JSON.stringify(data);
        $.ajax({
            url: 'http://localhost:7033/security/v1/api/user/' + id,
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
        url: 'http://localhost:7033/security/v1/api/user/' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data){
            var name = `${data.data.person.firstName} ${data.data.person.lastName}`
            $('#id').val(data.data.id);
            $('#username').val(data.data.username);
            $('#password').val(data.data.password);
            $('#person').val(name);
            $('#role').val(data.data.role.name);
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
        url: 'http://localhost:7033/security/v1/api/user/' + id,
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
    $('#username').val('');
    $('#password').val('');
    $('#person').val('');
    $('#role').val('');
    $('#state').val('');
}

//Función para mostrar los datos en una tabla
function loadData() {
    $.ajax({
        url: 'http://localhost:7033/security/v1/api/user',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            var html = '';
            var data = response.data;
            if (Array.isArray(data)) {
                data.forEach(function (item) {
                    html +=
                        `<tr>
                    <td>${item.username}</td>
                    <td>${item.password}</td>
                    <td>${item.person.firstName} ${item.person.lastName}</td>
                    <td>${item.role.name}</td>
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
    return loadPerson(), loadRole();
}

//Autocomplete 
function loadPerson() {
    $.ajax({
        url: 'http://localhost:7033/security/v1/api/person',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            if (response.status && Array.isArray(response.data)) {
                var persons = response.data.map(function (person) {
                    return {
                        label: `${person.firstName} ${person.lastName}`,
                        value: person.id
                    };
                });
                $('#person').autocomplete({
                    source: function (request, response) {
                        var results = $.ui.autocomplete.filter(persons, request.term);
                        if (!result.length) {
                            results = [{ label: 'No hay datos', value: null }];
                        }
                        respose(results);
                    },
                    select: function (even, ui) {
                        $('#selected_person').val(ui.item.value);
                        $('#person').val(ui.item.label);
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
function loadRole() {
    $.ajax({
        url: 'http://localhost:7033/security/v1/api/role',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            if (response.status && Array.isArray(response.data)) {
                var roles = response.data.map(function (role) {
                    return {
                        label: role.name,
                        value: role.id
                    };
                });
                $('#role').autocomplete({
                    source: function (request, response) {
                        var results = $.ui.autocomplete.filter(roles, request.term);
                        if (!result.length) {
                            results = [{ label: 'No hay datos', value: null }];
                        }
                        respose(results);
                    },
                    select: function (even, ui) {
                        $('#selected_role').val(ui.item.value);
                        $('#role').val(ui.item.label);
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