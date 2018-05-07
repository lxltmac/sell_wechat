function up() {
    if($("#product").hasClass("close")){
        $("#product").attr("class","open");
    }else{
        $("#product").attr("class","close dropup");
    }
}

function categoryUp() {
    if($("#category").hasClass("close")){
        $("#category").attr("class","open");
    }else{
        $("#category").attr("class","close dropup");
    }
}
