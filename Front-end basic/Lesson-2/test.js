function getInFormation() {
    var name = document.getElementById("name").value;
    console.log(name);

    var address = document.getElementById("address").value;
    console.log(address);

    var phone = document.getElementById("phone").value;
    console.log(phone);

    // cách lấy giá trị của thẻ input type radio
    var gender = document.querySelector('input[name="gender"]:checked').value;
    console.log(gender);

    var job = document.getElementById("job").value;
    console.log(job)

    var checkedValue = document.querySelector('.option:checked').value;
    console.log(checkedValue)
}