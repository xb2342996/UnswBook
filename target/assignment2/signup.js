$(function(){
    $('#signform').submit(function(){
        $.ajax({
            type:'post',
            url:'/signup',
            data:$(this).serialize(),

            success:function(data){
                if (data == 'success'){
                    alert("You have signed up, Please check your E-mail box to active your account!");
                    window.location.href='/login.jsp'
                }else if(data == 'failure'){
                    alert("This account has already existed, Please change another username!");
                }
            }
        });
        return false;
    });
});