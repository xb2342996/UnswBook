$(function(){
    $('#datepicker').datepicker({
        changeMonth: true,
        changeYear: true
    });
    $('#signform').validate();
    $('#signform').submit(function(){
        if($(this).valid()) {
            $.ajax({
                type: 'post',
                url: '/signup',
                data: $(this).serialize(),

                success: function (data) {
                    if (data == 'success') {
                        alert("You have signed up, Please check your E-mail box to active your account!");
                        window.location.href = '/login.jsp'
                    } else if (data == 'failure') {
                        alert("This account has already existed, Please change another username!");
                    }
                }
            });
        }
        return false;
    });
});
jQuery.validator.addMethod('equal', function (value, element, selector) {
   return this.optional(element) || $(selector).val() === value;
}, 'Password not same');
jQuery.validator.addMethod('regex', function (value, element, regexp) {
    var reg = new RegExp(regexp);
    return this.optional(element) || reg.test(value);
}, 'Illegal Password');
jQuery.validator.addMethod("email", function (value, element) {
    return /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test(value);
}, 'Wrong Email Address');
