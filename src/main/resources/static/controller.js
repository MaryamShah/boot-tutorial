/**
 * Created by pooya on 1/13/17.
 */

$.ajaxSetup({
    contentType: "application/json; charset=utf-8"
});
function save(){

    var data = {};
    data.name=$("#name").val();
    data.family=$("#family").val();
    $.ajax({
        type:"POST",
        url:"/com/yasan/",
        data:JSON.stringify(data),
        success:function(success){
            console.log(success);
        }

    })
}

function search(){

    var data = {};
    data.name=$("#name").val();
    data.family=$("#family").val();
    $.ajax({
        type:"POST",
        url:"/com/yasan/search",
        data:JSON.stringify(data),
        success:function(success){
            console.log(success);
        }

    })
}