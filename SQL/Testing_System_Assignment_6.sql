USE Testing_system_assignment_1;


#Cau 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó

DELIMITER $$
CREATE PROCEDURE Proc_get_account_in_departmentName(
IN in_departmentName VARCHAR(30))
	BEGIN
    SELECT 
    *
FROM
    `Account` A
WHERE
    EXISTS( SELECT 
            1
			FROM
				Department D
			WHERE
				A.DepartmentID = D.DepartmentID
			AND D.DepartmentName = in_departmentName);
	END$$
DELIMITER ;

call testing_system_assignment_1.Proc_get_account_in_departmentName('Sale');
call testing_system_assignment_1.Proc_get_account_in_departmentName('Dev');
call testing_system_assignment_1.Proc_get_account_in_departmentName('No person');



#Cau 2 Tạo store để in ra số lượng account trong mỗi group
-- dau vao IN_groupID
-- dau ra OUT_Sl_account_trong_group


DELIMITER $$
CREATE PROCEDURE Proc_SLAccount_in_group (IN IN_GroupID INT )
BEGIN
		SELECT COUNT(GA.AccountID) AS OUT_Sl_account_trong_group
		FROM `GroupAccount` GA
		JOIN `Group` G ON G.GroupID = GA.GroupID
        WHERE G.GroupID = IN_GroupID;
END$$
DELIMITER ;

call testing_system_assignment_1.Proc_SLAccount_in_group(3);
call testing_system_assignment_1.Proc_SLAccount_in_group(1);



#Cau 3 Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại

DELIMITER $$
	CREATE PROCEDURE Proc_SL_question_create_in_themonth ()
		BEGIN
			SELECT TQ.TypeName, COUNT(Q.TypeID) AS SL_question_create_in_themonth
            FROM `TypeQuestion` TQ
			JOIN `Question` Q ON TQ.TypeID = Q.TypeID
			WHERE YEAR(Q.CreateDate) = YEAR(NOW()) AND MONTH(Q.CreateDate) = MONTH(NOW())
			GROUP BY Q.TypeID;
		END$$
DELIMITER ;

call testing_system_assignment_1.Proc_SL_question_create_in_themonth();



#cau 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
SET GLOBAL log_bin_trust_function_creators = 1;
DELIMITER $$
CREATE FUNCTION F_TQ_Maxcauhoi() RETURNS INT
BEGIN
DECLARE typeId_co_sl_question_max int;
SELECT 
    Q.TypeID INTO typeId_co_sl_question_max
FROM
    Question Q
GROUP BY Q.TypeID
HAVING COUNT(Q.QuestionID) = (	SELECT 
					COUNT(Q1.QuestionID)
				FROM
					Question Q1
				GROUP BY Q1.TypeID
                ORDER BY COUNT(Q1.QuestionID) DESC LIMIT 1);
                return typeId_co_sl_question_max;
END$$
DELIMITER ;




#cau 6:Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tênchứa chuỗi của người dùng nhập vào hoặc trả về user có username chứachuỗi của người dùng nhập vào
-- nhập vào 1 chuỗi, trả ra tên của group, hoặc username của account mà chứa cái chuỗi đó
-- đầu vào: in_sequence varchar(255);
DELIMITER $$
CREATE PROCEDURE proc_cau6(
	IN in_sequence VARCHAR(30))
		BEGIN
			SELECT A.UserName AS result FROM `Account` A WHERE A.UserName LIKE CONCAT('%', in_sequence, '%')
			UNION
			SELECT G.GroupName AS result FROM `Group` G WHERE G.GroupName LIKE CONCAT('%', in_sequence, '%');
		END$$
DELIMITER ;


#cau 7:Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công


#cau 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
-- dau vao IN_TQ.TypeName
-- dau ra OUT_LENGTH(Q.content)
SELECT Q.*, LENGTH(Q.Content) AS Do_dai1
FROM `Question` Q 
JOIN `TypeQuestion` TQ ON TQ.TypeID = Q.TypeID
WHERE LENGTH(Q.Content) = (SELECT MAX(c)
FROM (Select LENGTH(Q.Content) AS c FROM `Question` Q) Test);

-- muon ra them do dai cua content
DELIMITER $$
CREATE PROCEDURE Proc_Cau8(IN IN_TypeName ENUM('Essay','Multiple-Choice'))
BEGIN
WITH CTE_dodaicontent AS(
SELECT LENGTH(Q.content) AS Do_dai FROM `Question` Q)
SELECT * FROM `Question` Q
JOIN `TypeQuestion` TQ ON TQ.TypeID = Q.TypeID 
WHERE LENGTH(Q.content) = (SELECT MAX(Do_dai) FROM CTE_dodaicontent)
HAVING TQ.TypeName = IN_TypeName;
END$$
DELIMITER ;

#Cau 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID

DELIMITER $$
CREATE PROCEDURE Proc_cau9(IN IN_ExamID INT)
BEGIN
DELETE FROM Exam E WHERE E.ExamID = IN_ExamID;
END$$
DELIMITER ;


INSERT INTO `testing_system_assignment_1`.`exam` (
`ExamID`, `Code`, `Title`, `CategoryID`, `Duration`, `CreatorID`, `CreateDate`) 
VALUES ('11', 'b', 'a', '1', '90', '11', '2020-09-09 00:00:00');

