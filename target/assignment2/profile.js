$(function(){
    $('#submitform').submit(function(){
        var form = new FormData(document.getElementById("submitform"));
        $.ajax({
            type:'post',
            url:'/profile',
            data:form,
            processData: false,
            contentType: false,
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
function selectimg() {
    $('#uploadImg').trigger("click");
    return false;
}