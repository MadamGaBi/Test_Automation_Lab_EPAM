$(document).ready(function () {

    $('#loginField').keyup(function () {
        login = $(this).val();
        if (login.length > 20) {
            var m = login.length - 20;
            $('#msgLog').html('Лимит превышен на '+ m +' символов').css("color","red");
        } else if (login.length <= 20) {
            var n = 20 - login.length;
            $('#msgLog').html('Осталось ввести '+ n +' символов').css("color","rgba(0, 0, 0, 0.7");
        }
    });

    // check login
    $('#loginField').blur(function(){
        if (login.length > 20) {
            $('#msgLog').html('Лимит превышен на '+ (login.length - 20) +' символов').css("color","red");
        } else if (login.length <= 20) {
            $('#msgLog').html("");
        }
    });

    $('#passwordField').keyup(function () {
        var password = $('#passwordField').val();
        if (password.length > 40) {
            var k = password.length - 40;
            $('#msgPass').html('Лимит превышен на '+ k +' символов').css("color","red");
        } else if (password.length <= 40) {
            var l = 40 - password.length;
            $('#msgPass').html('Осталось ввести '+ l +' символов').css("color","rgba(0, 0, 0, 0.7");
        }
    });

    // check password
    $('#passwordField').blur(function(){
        if (login.length > 40) {
            $('#msgPass').html('Лимит превышен на '+ (login.length - 40) +' символов').css("color","red");
        } else if (login.length <= 40) {
            $('#msgPass').html("");
        }
    });
});



