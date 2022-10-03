-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo
-- trước 1 năm trước

DROP TRIGGER IF EXISTS trigger_cau1;

DELIMITER $$

CREATE TRIGGER trigger_cau1
BEFORE INSERT ON `Group`
FOR EACH ROW
BEGIN
DECLARE V_CreateDate DATETIME;
SET V_CreateDate = DATE_SUB(Now(), INTERVAL 1 YEAR);
IF (NEW.CreateDate <= V_CreateDate) THEN 
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = 'KHONG DUOC THEM VAO GROUP';
END IF;
END $$
DELIMITER ;

INSERT INTO `Group` ( GroupName , CreatorID , CreateDate) 
			VALUES (N'Test' , 2,'2021-10-06');
            
            
-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
-- department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
-- "Sale" cannot add more user"           
DROP TRIGGER IF EXISTS trg_cau2;
DELIMITER $$
CREATE TRIGGER trg_cau2
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
	DECLARE v_DepartmentID INT;
    SELECT DepartmentID INTO v_DepartmentID From `department`
    WHERE DepartmentName = 'Sale';
    IF (NEW.DepartmentID = v_DepartmentID) THEN 
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
END IF;
END $$
DELIMITER ;



-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user

DROP TRIGGER IF EXISTS trig_validate_insert_group_max_5_acc;
delimiter $$
CREATE TRIGGER trig_validate_insert_group_max_5_acc
BEFORE INSERT ON `groupaccount`
FOR EACH ROW
BEGIN
	DECLARE count_acc INT;
    declare message varchar(255) default concat('Cant insert account with groupId: ', new.groupId,  '. Because this group is fulfill (5acc)');
	SELECT 
		COUNT(ga.AccountID)
	INTO count_acc FROM
		`group` g
			JOIN
		groupaccount ga ON g.GroupID = ga.GroupID
	GROUP BY g.GroupID
	HAVING g.GroupID = NEW.GroupID;
    IF count_acc >= 5 THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Khong the xoa account';
    END IF;
END $$
DELIMITER ;



-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
DROP TRIGGER IF EXISTS trig_validate_insert_exam_max_10_question;
DELIMITER $$
CREATE TRIGGER trig_validate_insert_exam_max_10_question
BEFORE INSERT ON examquestion
FOR EACH ROW
BEGIN
	DECLARE count_Ques INT;
    DECLARE message Varchar(255) DEFAULT concat('Cant insert account with ExamId: ', new.ExamId,  '. Because this Exam is fulfill (10Ques)');
	SELECT
    COUNT(EQ.QuestionID)
    INTO count_Ques
    FROM ExamQuestion EQ
    GROUP BY EQ.ExamID
    HAVING EQ.ExamID = new.ExamID;
    IF count_Ques >= 10 THEN
    signal sqlstate '45000'
        set message_text = message;
    end if;
END$$
delimiter ;

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
-- admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
-- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông
-- tin liên quan tới user đó
DROP TRIGGER IF EXISTS Trigger_cau5;
DELIMITER $$ 
CREATE TRIGGER Trigger_cau5
BEFORE DELETE ON `Account`
FOR EACH ROW
BEGIN
	DECLARE V_Email VARCHAR(50);
    SET V_Email = 'thinh.nguyenhuu@vti.com.vn';
    IF (OLD.EMail = V_Email) THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Khong the xoa account';
    END IF;
END $$
DELIMITER ;

DELETE FROM `Account` WHERE AccountID = 4;


-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
-- Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
-- vào departmentID thì sẽ được phân vào phòng ban "waiting Department"

DROP TRIGGER IF EXISTS Trg_cau6;
DELIMITER $$ 
CREATE TRIGGER Trg_cau6
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
	DECLARE V_waiting_Department VARCHAR(50);
    SELECT DepartmentID INTO V_waiting_Department
    FROM Department WHERE DepartmentName = 'waiting Department';
    IF (NEW.DepartmentID IS NULL) THEN
    SET NEW.DepartmentID = V_waiting_Department;
    END IF;
END $$
DELIMITER ;

                
-- Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
-- question, trong đó có tối đa 2 đáp án đúng.
DROP TRIGGER IF EXISTS Trg_cau7;
DELIMITER $$ 
CREATE TRIGGER Trg_cau7
BEFORE INSERT ON `Answer`
FOR EACH ROW
BEGIN
	DECLARE V_count_QuestionID INT;
    DECLARE V_count_isCorrect INT;
    SELECT COUNT(QuestionID) INTO V_count_QuestionID FROM `Answer` WHERE QuestionID = NEW.QuestionID;
    SELECT COUNT(1) INTO V_count_isCorrect FROM `Answer`
    WHERE QuestionID = NEW.QuestionID AND isCorrect = NEW.isCorrect ;
    IF (V_count_QuestionID >=4) OR (V_count_isCorrect >=2) THEN
    SIGNAL SQLSTATE '12456'
    SET MESSAGE_TEXT = '1 cau hoi co toi da 4 cau tra loi';
    END IF;
END $$
DELIMITER ;

-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
DROP TRIGGER IF EXISTS Trg_cau9;
DELIMITER $$ 
CREATE TRIGGER Trg_cau9
BEFORE DELETE ON `Exam`
FOR EACH ROW
BEGIN
	DECLARE V_CreateDate DATETIME;
    SET V_CreateDate = DATE_SUB(Now(), INTERVAL 2 DAY);
IF (OLD.CreateDate >= V_CreateDate) THEN 
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = 'KHONG XOA DC BAI THI MOI';
END IF;
END $$
DELIMITER ;

DELETE FROM `Exam` WHERE ExamID = 11;

-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các
-- question khi question đó chưa nằm trong exam nào
-- Update
