function add(button, friendName, friendEmail, isFriend) {
    var title = !isFriend ?  "add Friend" : "cancal Friend";
    $(button).text(title);
    $.ajax({
        type:'GET',
        url:'/addFriend?action=addFriend',
        data:{"friendName":friendName,"friendEmail":friendEmail,"flag":isFriend}
    })
}