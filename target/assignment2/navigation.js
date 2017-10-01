$(function(){
    $('#searchform').submit(function(){
        $.ajax({
            url:'/searchFriends',
            data:$(this).serialize(),
            success:function(data){
                if (data == 'success'){
                    window.location.href='/searchResult.jsp'
                }else {
                    alert(data)
                }
            }
        });
        return false;
    });
});