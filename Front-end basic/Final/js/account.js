function Account(username, age, phone, email, id) {
    this.username = username;
    this.age = age;
    this.phone = phone;
    this.email = email;
    this.id = id;
}

var listAccount = [];

var baseAPI = "https://63a073aa24d74f9fe838a03d.mockapi.io/Account"

function addNewAccount() {
    console.log($('#myModal'))
    $('#modalAccount').modal('show');
}


$(function () {
    getListAccount()
})
function getListAccount() {
    $.ajax({
        url: baseAPI,
        type: 'GET',
        error: function(err){
            console.log(err)
    },
        success: function(data){
            listAccount = data;
            fillAccountToTable();
    }
    });
}


function fillAccountToTable(){
    listAccount.forEach(element =>{
        console.log(element)
    })
}
