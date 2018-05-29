function processMail() {
    var email = $('#email').val();
    var name = $('#name').val();
    var message = $('#message').val();
    console.log(email);
    console.log(name);
    $.ajax("/mail", {
        method: "POST",
        contentType: "application/json; charset=UTF-8",
        data: JSON.stringify({
            senderEmail: email,
            senderName: name,
            message: message,
            status: 'NEW'

        })
    });

    // document.getElementById("form-padding")
    $('#email-form')[0].reset();

}

// button.onclick = function () {
//     processMail();
// }