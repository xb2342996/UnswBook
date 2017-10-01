$(function(){
    $('#submitform').submit(function(){
        $.ajax({
            type:'post',
            url:'/profile',
            data:$(this).serialize(),
            success:function(data){
                if (data == 'success'){
                    alert("Change successfully!");
                    window.location.href='/home.jsp'
                }else {
                    alert(data)
                }
            }
        });
        return false;
    });
});