setInterval(function(){
    $.ajax({
        type:'POST',
        url:'/notification?action=friend',
        success:function(data) {
            console.log(data.length);
            if (data.length != 0) {
                alert(data);
            }
        }
    });
},10000);

setInterval(function(){
    $.ajax({
        type:'POST',
        url:'/notification?action=like',
        success:function(data) {
            console.log(data.length);
            if (data.length != 0) {
                alert(data);
            }
        }
    });
},10000);

function selectimg() {
    $('#uploadImg').trigger("click");
    return false;
}

function like(button, mid, username) {
    var title='';
    if($(button).find('span').hasClass("glyphicon glyphicon-heart")){
        $(button).find('span').attr("class", "glyphicon glyphicon-heart-empty");
        title='Like';
    }else {
        $(button).find('span').attr("class", "glyphicon glyphicon-heart");

        title='UnLike';
    }
    $.ajax({
        type:'POST',
        url:'/like',
        data:{"messageId":mid,"flag":title,"friend":username}
    })
}
$(function(){
    $('#messageform').submit(function(){
        var form = new FormData(document.getElementById("messageform"));
        $.ajax({
            type:'POST',
            url:'/message',
            processData: false,
            contentType: false,
            data: form,
            success:function(data){
                alert(data);
                window.location.href='/home.jsp';
            }
        });
        return false;
    });
});