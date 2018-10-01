$(document).ready(function () {
    $('#verificar').click(function () {
        $.ajax({
            url: 'webresources/login/' + $('#login').val(),
            method: 'POST',
            data: {
                senha: $('#senha').val()
            },
            success: function (data) {
                $('#autorizacao').val(data);
            },
            statusCode: {
                401: function (xhr) {
                    $('#autorizacao').val(xhr.responseText);
                },
                404: function () {
                    $('#autorizacao').val('Entre com o login e a senha!');
                }
            }
        });
    });
});
