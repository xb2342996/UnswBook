$(function(){
    $('#datepicker').datepicker({
        changeMonth: true,
        changeYear: true
    });

    $('#submitform').validate();
    $('#submitform').submit(function(){
        if ($(this).valid) {
            var form = new FormData(document.getElementById("submitform"));
            $.ajax({
                type: 'post',
                url: '/profile',
                data: form,
                processData: false,
                contentType: false,
                success: function (data) {
                    if (data == 'success') {
                        alert("Change successfully!");
                        window.location.href = '/home.jsp'
                    } else {
                        alert(data)
                    }
                }
            });
        }
        return false;
    });
});
function selectimg() {
    $('#uploadImg').trigger("click");
    return false;
}
jQuery.validator.addMethod("email", function (value, element) {
    return /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test(value);
}, 'Wrong Email Address');