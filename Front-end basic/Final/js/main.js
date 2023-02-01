$(function () {



    $("#header").load("./html/header.html");
    $("#main").load("./html/account.html");
    $("#footer").load("./html/footer.html");
});

function clickNavihome(){
    $("#main").load("./html/main.html");
}

function clickNaviViewListAccount(){
    $("#main").load("./html/account.html");
}

function clickNaviViewListDepartment(){
    $("#main").load("./html/departmentt.html");
}