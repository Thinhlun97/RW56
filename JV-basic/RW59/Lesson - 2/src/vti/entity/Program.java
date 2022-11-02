package vti.entity;

import com.vti.entity.enumtype.PositionName;
import com.vti.entity.enumtype.TypeName;

import java.time.LocalDate;

public class Program {
    public static void main(String[] args){

        //Department
        Department department1 = new Department();
        department1.departmentId = 1;
        department1.departmentname = "Sale";

        Department department2 = new Department();
        department2.departmentId = 2;
        department2.departmentname = "Ban Hang";

        Department department3 = new Department();
        department3.departmentId = 3;
        department3.departmentname = "Bao Ve";

        //Position
        Position position1 = new Position();
        position1.positionId = 1;
        position1.positionName = PositionName.DEV;

        Position position2 = new Position();
        position2.positionId = 2;
        position2.positionName = PositionName.TEST;

        Position position3 = new Position();
        position3.positionId = 3;
        position3.positionName = PositionName.SCRUM_MASTER;

        Position position4 = new Position();
        position4.positionId = 4;
        position4.positionName = PositionName.PM;


        //Account
        Account account1 = new Account();
        account1.accountId = 1;
        account1.email = "acc1@gmail.com";
        account1.username = "nguyen";
        account1.fullname = "thinh";
        account1.department = department1;
        account1.position = position1;
        account1.createDate = LocalDate.parse("2019-04-05");

        Account account2 = new Account();
        account2.accountId = 2;
        account2.email = "acc2@gmail.com";
        account2.username = "nguyen";
        account2.fullname = "nam";
        account2.department = department2;
        account2.position = position2;
        account2.createDate = LocalDate.parse("2019-05-05");

        Account account3 = new Account();
        account3.accountId = 3;
        account3.email = "acc3@gmail.com";
        account3.username = "nguyen";
        account3.fullname = "long";
        account3.department = department3;
        account3.position = position3;
        account3.createDate = LocalDate.parse("2019-06-05");

        //Group
        Group group1 = new Group();
        group1.groupId = 1;
        group1.groupName = "bóng đá";
        group1.creator = account1;
        group1.createDate = LocalDate.parse("2019-08-08");
        Account[] listAccount = {account1};
        group1.accounts = listAccount;

        Group[] listGroup = {group1};
        account1.groups = listGroup;

        //TypeQuestion
        TypeQuestion typeQuestion1 = new TypeQuestion();
        typeQuestion1.typeId = 1;
        typeQuestion1.typeName = TypeName.ESSAY;

        TypeQuestion typeQuestion2 = new TypeQuestion();
        typeQuestion2.typeId = 2;
        typeQuestion2.typeName = TypeName.MULTIPLE_CHOICE;

        //CategoryQuestion
        CategoryQuestion categoryQuestion1 = new CategoryQuestion();
        categoryQuestion1.categoryId = 1;
        categoryQuestion1.categoryName = "Java";

        CategoryQuestion categoryQuestion2 = new CategoryQuestion();
        categoryQuestion2.categoryId = 2;
        categoryQuestion2.categoryName = "SQL";

        CategoryQuestion categoryQuestion3 = new CategoryQuestion();
        categoryQuestion3.categoryId = 3;
        categoryQuestion3.categoryName = "Ruby";

        CategoryQuestion categoryQuestion4 = new CategoryQuestion();
        categoryQuestion4.categoryId = 4;
        categoryQuestion4.categoryName = "Postman";

        //Question
        Question question1 = new Question();
        question1.questionId = 1;
        question1.content = "câu hỏi về Java";
        question1.categoryQuestion = categoryQuestion1;
        question1.typeQuestion = typeQuestion1;
        question1.creator = account1;
        question1.createDate = LocalDate.parse("2019-09-20");

        Question question2 = new Question();
        question2.questionId = 2;
        question2.content = "câu hỏi về SQL";
        question2.categoryQuestion = categoryQuestion1;
        question2.typeQuestion = typeQuestion1;
        question2.creator = account2;
        question2.createDate = LocalDate.parse("2019-09-21");

        Question question3 = new Question();
        question3.questionId = 3;
        question3.content = "câu hỏi về Ruby";
        question3.categoryQuestion = categoryQuestion1;
        question3.typeQuestion = typeQuestion2;
        question3.creator = account1;
        question3.createDate = LocalDate.parse("2019-09-22");

        Question question4 = new Question();
        question4.questionId = 4;
        question4.content = "câu hỏi về Postman";
        question4.categoryQuestion = categoryQuestion2;
        question4.typeQuestion = typeQuestion2;
        question4.creator = account3;
        question4.createDate = LocalDate.parse("2019-09-23");


        //Answer
        Answer answer1 = new Answer();
        answer1.answerId = 1;
        answer1.content = "câu trả lời Java";
        answer1.question = question1;
        answer1.isCorrect = true;

        Answer answer2 = new Answer();
        answer2.answerId = 2;
        answer2.content = "câu trả lời SQL";
        answer2.question = question2;
        answer2.isCorrect = false;

        Answer answer3 = new Answer();
        answer3.answerId = 3;
        answer3.content = "câu trả lời Ruby";
        answer3.question = question3;
        answer3.isCorrect = true;

        Answer answer4 = new Answer();
        answer4.answerId = 4;
        answer4.content = "câu trả lời Postman";
        answer4.question = question4;
        answer4.isCorrect = true;


        //Exam
        Exam exam1 = new Exam();
        exam1.examId = 1;
        exam1.code = "a101";
        exam1.title = "đề thi Java";
        exam1.categoryExam = categoryQuestion1;
        exam1.duration = 90;
        exam1.creator = account1;
        exam1.createDate = LocalDate.parse("2020-01-02");

        Exam exam2 = new Exam();
        exam2.examId = 2;
        exam2.code = "a102";
        exam2.title = "đề thi SQL";
        exam2.categoryExam = categoryQuestion2;
        exam2.duration = 100;
        exam2.creator = account2;
        exam2.createDate = LocalDate.parse("2020-01-03");

        Exam exam3 = new Exam();
        exam3.examId = 3;
        exam3.code = "a103";
        exam3.title = "đề thi Ruby";
        exam3.categoryExam = categoryQuestion3;
        exam3.duration = 90;
        exam3.creator = account3;
        exam3.createDate = LocalDate.parse("2020-01-01");



//        IF
//        Question1
        if(account2.department == null){
            System.out.printf("Nhân viên này chưa có phòng ban");
        }else {
            System.out.printf("Nhân viên này thuộc phòng ban " +  account2.department.departmentname);
        }

//        //Question2
//        if(account2.groups.length == 1 || account2.groups.length == 2){
//            System.out.println("Group của nhân viên Java");
//        }else if (account2.groups.length == 3){
//            System.out.println("Nhân viên này là người" + "quan trọng, tham gia nhiều group");
//        }else if (account2.groups.length == 4 ){
//            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
//        }else if (account2.groups == null){
//            System.out.println("Nhân viên này chưa có group");
//        }

//        //Question3
//        System.out.println(account2.department == null ? "Nhân viên này chưa có phòng ban"
//                : "Phòng ban của nhân viên này là " + account2.department.departmentname);

//        //Question4
//        System.out.println(account1.position == position1 ? "Đây là Developer"
//                : "Người này không phải là Developer");


////        //Switch Case
//            //Question5
//        Account[] nhom1 = new Account[2];
//        nhom1[0] = account1;
//        nhom1[1] = account2;
////        nhom1[2] = account3;
//
//        switch (nhom1.length){
//            case 1:
//                System.out.println(" nhóm có 1 thành viên");
//                break;
//            case 2:
//                System.out.println(" nhóm có 2 thành viên");
//                break;
//            case 3:
//                System.out.println(" nhóm có 3 thành viên");
//                break;
//            default:
//                System.out.println(" nhóm có nhiều thành viên ");
//        }


//        //Question7
//        switch (account1.position.positionName){
//            case DEV:
//                System.out.println(" Đây là Developer ");
//                break;
//            default:
//                System.out.println(" Người này không phải Developer");
//
//        }

//        //Question8
//        for( Account ac : args) {
//            System.out.println(ac.email + " " + ac.fullname + " " + ac.department.departmentname);
        }
}
