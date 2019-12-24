$(function () {
    let base_url = 'http://localhost:3000/';

    $("#btn_register").on('click', function (e) {
        e.preventDefault();

        let user = {
            username: $("#username").val(),
            password: $("#password").val(),
        };
        $.ajax({
            type: 'POST',
            url: base_url + 'users/signup',
            data: user,
            success: function (user) {
                console.log(user);
                alert("You will be redirected to another page.");
                window.location="../index.html";
            },
            error: function () {
                alert("Fill all the form fields!");
            }
        });
    });
});