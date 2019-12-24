$(function() {
  let base_url = 'http://localhost:3000/';

  $('#btn_login').on('click', function(e) {
    e.preventDefault();

    let user = {
      username: $('#username').val(),
      password: $('#password').val()
    };
    $.ajax({
      type: 'POST',
      contentType: 'application/json',
      url: base_url + 'users/login',
      data: user,
      success: function(user) {
        console.log(user);
        // $('#login-form').trigger('reset');
        alert('You will be redirected to another page.');
        window.location = '../index.html';
      },
      error: function() {
        alert('Fill all the form fields!');
      }
    });
  });
});