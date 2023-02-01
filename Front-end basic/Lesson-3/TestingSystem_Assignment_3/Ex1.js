function Department(DepartmentId, DepartmentName) {
    this.DepartmentId = DepartmentId;
    this.DepartmentName = DepartmentName;
}

function Position(PositionId, PositionName) {
    this.PositionId = PositionId;
    this.PositionName = PositionName;
}

function Account(AccountId,Email,UserName,FullName,DepartmentId,PositionId,CreateDate){
    this.AccountId = AccountId;
    this.Email = Email;
    this.UserName = UserName;
    this.FullName = FullName;
    this.DepartmentId = DepartmentId;
    this.PositionId = PositionId;
    this.CreateDate = CreateDate;
}

function Group(GroupId,GroupName,CreatorId,CreateDate){
    this.GroupId = GroupId;
    this.GroupName = GroupName;
    this.CreatorId = CreatorId;
    this.CreateDate = CreateDate;
}

function GroupAccount(GroupId,AccountId,JoinDate){
    this.GroupId = GroupId;
    this.AccountId = AccountId;
    this.JoinDate = JoinDate;
}

var Department1 = new Department(1,"Giamdoc")
var Department2 = new Department(2,"TruongPhong")
var Department3 = new Department(3,"NhanVien")
console.log(Department1)
console.log(Department2)
console.log(Department3)

var Position1 = new Position(1,"DEV")
var Position2 = new Position(2,"PM")
var Position3 = new Position(3,"TEST")

console.log(Position1)
console.log(Position2)
console.log(Position3)

var Account1 = new Account(1,"nguyena@gmail.com","vana","Nguyen van A",1,1,"2021-08-09")
var Account2 = new Account(2,"nguyenb@gmail.com","vanb","Nguyen van B",2,3,"2021-09-09")
var Account3 = new Account(3,"nguyenc@gmail.com","vanc","Nguyen van C",3,2,"2021-07-09")

var arr_acc=[Account1,Account2,Account3]

console.log(Account1)
console.log(Account2)
console.log(Account3)

var Group = new Group(1,)




//Question 2.1.1
if(Account2.DepartmentId == null){
    console.log("Nhan vien nay chua co phong ban")
}else{
    console.log("Phong ban cua nhan vien nay la" + Account2.DepartmentId)
}


arr_acc.forEach(element => {
    console.log(element)
})


ex2_1();
function ex2_1(){
    for (let index = 0; index < 10; index++) {
        if(index % 2 == 0){
            console.log(index)
        }
        
    }
}

function ex2_2(Account){
    console.log("Thong tin acc", Account.AccountId,Account.Email)
}
ex2_2(Account1);

function ex2_3(){
    for (let index = 0; index < 10; index++) {
        console.log(index)
        
    }
}
ex2_3();


function ex3_1(){
    var rs = document.getElementById("ex3_1").value;
    if(rs % 2 == 0){
        document.getElementById("rs3_1").innerHTML = "";
        document.getElementById("rs3_1").append("So vua nhap vao la so chan");
    } else{
        document.getElementById("rs3_1").innerHTML = "";
        document.getElementById("rs3_1").append("So vua nhap vao la so le")
    }
console.log(rs)
}

function ex3_5(){
    var month = document.getElementById("month").value;
    var year = document.getElementById("year").value;
    var dateString = year + "-" + month;
var date = new Date(dateString);
var lastDay = new Date(date.getFullYear(), date.getMonth() + 1,0);
document.getElementById("kq3_5").innerHTML = "";
document.getElementById("kq3_5").append(lastDay.getDate());

console.log(lastDay.getDate());
}