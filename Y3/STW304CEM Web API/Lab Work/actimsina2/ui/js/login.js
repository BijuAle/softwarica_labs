$(function() {
  $.ajaxSetup({
    xhrFields: {
      withCredentials: true
    }
  });

  let base_url = "http://localhost:3000/";

  $("#btn_login").on("click", function(e) {
    e.preventDefault();
    let user = {
      username: $("#username").val(),
      password: $("#password").val()
    };

    $.ajax({
      type: "POST",
      url: base_url + "users/login",
      data: user,
      dataType: "json",
      success: function(user) {
        console.log(user);
        alert("You will be redirected to another page.");
        window.location = "../index.html";
      },
      error: function(err) {
        //alert("Fill all the form fields!");
        console.log(err);
      }
    });
  });
});
