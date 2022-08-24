DROP DATABASE IF EXISTS Testing_system_assignment_1;
CREATE DATABASE Testing_system_assignment_1;

USE Testing_system_assignment_1;

DROP TABLE IF EXISTS `Department`;
CREATE TABLE `Department`(
	DepartmentID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName VARCHAR(30) NOT NULL UNIQUE
);

DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position`(
	PositionID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName ENUM ('Dev', 'Test', 'Scrum Master', 'PM') NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email VARCHAR(50) NOT NULL UNIQUE KEY,
	Username VARCHAR(50) NOT NULL UNIQUE KEY,
    FullName VARCHAR(50) NOT NULL,
    DepartmentID TINYINT UNSIGNED NOT NULL,
    PositionID TINYINT UNSIGNED NOT NULL,
    CreateDate DATETIME DEFAULT NOW(),
    FOREIGN KEY(DepartmentID) REFERENCES `Department`(DepartmentID),
    FOREIGN KEY(PositionID) REFERENCES `Position`(PositionID)
);

DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	GroupID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName Varchar(50) NOT NULL UNIQUE KEY,
    CreatorID TINYINT UNSIGNED,
    CreateDate DATETIME DEFAULT NOW(),
    FOREIGN KEY(CreatorID) REFERENCES `Account`(AccountID)
);

DROP TABLE IF EXISTS `GroupAccount`;
CREATE TABLE `GroupAccount`(
	GroupID TINYINT UNSIGNED NOT NULL,
    AccountID TINYINT UNSIGNED NOT NULL,
    JoinDate DATETIME DEFAULT NOW(),
    PRIMARY KEY (GroupID , AccountID),
    FOREIGN KEY(GroupID) REFERENCES `Group`(GroupID),
    FOREIGN KEY(AccountID) REFERENCES `Account`(AccountID)
);

DROP TABLE IF EXISTS `TypeQuestion`;
CREATE TABLE `TypeQuestion`(
	TypeID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName ENUM('Essay','Multiple-Choice') NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS `CategoryQuestion`;
CREATE TABLE `CategoryQuestion`(
	CategoryID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName VARCHAR(50) NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS `Question`;
CREATE TABLE `Question`(
	QuestionID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content VARCHAR(50) NOT NULL,
    CategoryID TINYINT UNSIGNED NOT NULL,
    TypeID TINYINT UNSIGNED NOT NULL,
    CreatorID TINYINT UNSIGNED NOT NULL,
    CreateDate DATETIME DEFAULT NOW(),
    FOREIGN KEY(CategoryID) REFERENCES `CategoryQuestion`(CategoryID),
    FOREIGN KEY(TypeID) REFERENCES `TypeQuestion`(TypeID),
    FOREIGN KEY(CreatorID) REFERENCES `Account`(AccountID)
);

DROP TABLE IF EXISTS `Answer`;
CREATE TABLE `Answer`(
	AnswerID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content VARCHAR(100) NOT NULL,
    QuestionID TINYINT UNSIGNED NOT NULL,
    isCorrect BIT DEFAULT 1,
    FOREIGN KEY(QuestionID) REFERENCES `Question`(QuestionID)
);

DROP TABLE IF EXISTS `Exam`;
CREATE TABLE `Exam`(
	ExamID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code` Char(10) NOT NULL,
    Title VARCHAR(50) NOT NULL,
    CategoryID TINYINT UNSIGNED NOT NULL,
    Duration TINYINT UNSIGNED NOT NULL,
    CreatorID TINYINT UNSIGNED NOT NULL,
    CreateDate DATETIME DEFAULT NOW(),
    FOREIGN KEY(CategoryID) REFERENCES `CategoryQuestion`(CategoryID),
    FOREIGN KEY(CreatorID) REFERENCES `Account`(AccountID)
);

DROP TABLE IF EXISTS `ExamQuestion`;
CREATE TABLE `ExamQuestion`(
	ExamID TINYINT UNSIGNED NOT NULL,
    QuestionID TINYINT UNSIGNED NOT NULL,
    PRIMARY KEY(ExamID , QuestionID),
    FOREIGN KEY(ExamID) REFERENCES `Exam`(ExamID),
    FOREIGN KEY(QuestionID) REFERENCES `Question`(QuestionID)
);

INSERT INTO `Department`(DepartmentName)
VALUE ('Makerting'),
			('Sale'),
            ('Bao ve'),
            ('Nhan su'),
            ('Ky thuat'),
            ('Tai chinh'),
            ('Pho giam doc'),
            ('Giam doc'),
            ('Thu ki'),
            ('No person'),
            ('ban hang');
            

INSERT INTO `Position`(PositionName)
VALUE ('Dev'),
			('Test'),
            ('Scrum Master'),
            ('PM');
            
INSERT INTO `Account`(Email, Username, Fullname, DepartmentID, PositionID, CreateDate)
VALUE ('Email1@gmail.com' ,'Username1' ,'Fullname1' , 5 , 1,'2020-03-05'),
			('Email2@gmail.com' ,'Username2' ,'Fullname2' , 1 , 2,'2020-03-05'),
			('Email3@gmail.com' ,'Username3' ,'Fullname3' , 2 , 2,'2020-03-07'),
			('Email4@gmail.com' ,'Username4' ,'Fullname4' , 3 , 4,'2020-03-08'),
			('Email5@gmail.com' ,'Username5' ,'Fullname5' , 4 , 4,'2020-03-10'),
			('Email6@gmail.com' ,'Username6' ,'Fullname6' , 6 , 3,'2020-04-05'),
			('Email7@gmail.com' , 'Username7' ,'Fullname7', 2 , 2 , NULL ),
			('Email8@gmail.com' , 'Username8' ,'Fullname8', 8 , 1 ,'2020-04-07'),
			('Email9@gmail.com' , 'Username9' ,'Fullname9', 2 , 2 ,'2020-04-07'),
			('Email10@gmail.com' , 'Username10' ,'Fullname10', 10 , 1 ,'2020-04-09'),
			('Email11@gmail.com' , 'Username11' ,'Fullname11', 10 , 1 , DEFAULT),
			('Email12@gmail.com' , 'Username12','Fullname12' , 10 , 1 , DEFAULT);
        
INSERT INTO `Group`(GroupName, CreatorID, CreateDate)
VALUE ('Testing System', 5, '2019-03-05'),
			('Development', 1, '2020-03-07'),
			('VTI Sale 01', 2, '2020-03-09'),
			('VTI Sale 02', 3, '2020-03-10'),
			('VTI Sale 03', 4, '2020-03-28'),
			('VTI Creator', 6, '2020-04-06'),
			('VTI Marketing 01', 7, '2020-04-07'),
			('Management', 8, '2020-04-08'),
			('Chat with love', 9, '2020-04-09'),
			('Vi Ti Ai', 10, '2020-04-10');
                
INSERT INTO `GroupAccount`(GroupID, AccountID, JoinDate)
VALUE (1, 1, '2019-03-05'),
			(1 , 2,'2020-03-07'),
			(3 , 3,'2020-03-09'),
			(3 , 4,'2020-03-10'),
			(5 , 5,'2020-03-28'),
			(1 , 3,'2020-04-06'),
			(1 , 7,'2020-04-07'),
			(8 , 3,'2020-04-08'),
			(1 , 9,'2020-04-09'),
			(10 , 10,'2020-04-10');

INSERT INTO `TypeQuestion`(TypeName)
VALUE ('Essay'),
			('Multiple-Choice');
            
INSERT INTO `CategoryQuestion`(CategoryName)
VALUE ('Java'),
			('ASP.NET'),
            ('ADO.NET'),
            ('SQL'),
            ('Postman'),
            ('Ruby'),
            ('Python'),
            ('C++'),
            ('C Sharp'),
            ('PHP');

INSERT INTO `Question`(Content, CategoryID, TypeID, CreatorID, CreateDate)
VALUE ('Cau hoi ve Java', 1, '1', '2','2020-04-05'),
			('Cau hoi ve PHP', 10, '2', '2','2020-04-05'),
			('Cau hoi ve C#', 9, '2', '3','2020-04-06'),
			('Cau hoi ve Ruby', 6, '1', '4','2020-04-06'),
			('Cau hoi ve Postman', 5, '1', '5','2020-04-06'),
			('Cau hoi ve ADO.NET', 3, '2', '6','2020-04-06'),
			('Cau hoi ve ASP.NET', 2, '1', '7','2020-04-06'),
			('Cau hoi ve C++', 8, '1', '8','2020-04-07'),
			('Cau hoi ve SQL', 4, '2', '9','2020-04-07'),
			('Cau hoi ve Python', 7, '1', '10','2020-04-07');

INSERT INTO `Answer`(Content, QuestionID, isCorrect)
VALUE ('tra loi 01', 1, 0),
			('tra loi 02', 1, 1),
			('tra loi 03', 1, 0),
			('tra loi 04', 1, 1),
			('tra loi 05', 2, 1),
			('tra loi 06', 3, 1),
			('tra loi 07', 4, 0),
			('tra loi 08', 8, 0),
			('tra loi 09', 9, 1),
			('tra loi 10', 10, 1);

INSERT INTO	`Exam`(`Code`, Title, CategoryID, Duration, CreatorID, CreateDate)
VALUE ('VTIQ001', 'De thi C#', 1, 60, '5', '2019-04-05'),
			('VTIQ002', 'De thi PHP', 10, 60, '2', '2019-04-05'),
			('VTIQ003', 'De thi C++', 9, 120, '2', '2019-04-07'),
            ('VTIQ004', 'De thi Java', 6, 60, '3', '2019-04-08'),
            ('VTIQ005', 'De thi Rubt', 5, 120, '4', '2019-04-10'),
            ('VTIQ006', 'De thi Postman', 3, 60, '6', '2019-04-05'),
            ('VTIQ007', 'De thi SQL', 2, 60, '7', '2019-04-05'),
			('VTIQ008', 'De thi Python', 8, 60, '8', '2019-04-07'),
            ('VTIQ009', 'De thi ADO.NET', 4, 90, '9', '2019-04-07'),
            ('VTIQ002', 'De thi ASP.NET', 7, 90, '10', '2019-04-08');
            
INSERT INTO `ExamQuestion`(ExamID, QuestionID)
VALUE (1 , 5),
			(2 , 10),
            (3 , 4),
            (4 , 3),
            (5 , 7),
            (6 , 10),
            (7 , 2),
            (8 , 10),
            (9 , 9),
            (10 , 8);