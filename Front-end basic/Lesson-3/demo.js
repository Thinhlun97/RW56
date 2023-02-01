// document.getElementById("demo1").innerHTML="123";

var carName="Toyota";
console.log(carName)

var number = 4;
console.log(number)

var abc=123;
console.log(Number.isInteger(abc));
console.log(Number.isInteger(abc.toString));

var test1="Tha thu";
console.log(test1.toLocaleUpperCase())


function Account(id, name, age){
    this.id = id;
    this.name = name;
    this.age = age;
}

var acc1 = new Account(1,"abc");
var acc2 = new Account(2,"nguyen van a");
var acc3 = new Account(1,"nguyen van b");

var arr1 = [acc1, acc2,acc3];
arr1.forEach(element => {console.log(element)})


// arr1.push(acc3);
// delete arr1[1];
// console.log(arr1);

// if(1){
//     console.log(1)
// }else{
//     console.log(2)
// }

function test(){
    console.log("đã click")
}