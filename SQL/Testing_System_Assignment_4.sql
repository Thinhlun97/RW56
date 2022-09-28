USE testing_system_assignment_1;


#câu 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT A.Username, A.FullName, D.DepartmentName, D.departmentID
FROM `Account` A
JOIN `Department` D ON D.departmentID = A.departmentID;

#câu 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
SELECT *
FROM `Account` A
WHERE CreateDate > '2010-12-20';

#câu 3: Viết lệnh để lấy ra tất cả các developer
SELECT A.*, P.PositionName
FROM `Account` A
JOIN `Position` P ON P.PositionID = A.PositionID
WHERE P.PositionName = 'Dev';

#câu 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT D.DepartmentName, COUNT(A.DepartmentID)
FROM `Department` D
JOIN `Account` A ON A.DepartmentID = D.DepartmentID
GROUP BY A.DepartmentID
HAVING COUNT(A.DepartmentID) > 2;

#câu 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
WITH CTE_SLSD AS
(SELECT Q.Content, Q.QuestionID, EQ.ExamID, COUNT(EQ.QuestionID) AS SL
FROM `Question` Q
JOIN `ExamQuestion` EQ ON EQ.QuestionID = Q.QuestionID
GROUP BY Q.QuestionID)

SELECT * FROM CTE_SLSD
WHERE SL = (SELECT MAX(SL) FROM CTE_SLSD);


#câu 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT Q.Content, CQ.CategoryName, COUNT(Q.CategoryID) AS SLSD
FROM `Question` Q
JOIN `CategoryQuestion` CQ ON Q.CategoryID = CQ.CategoryID
GROUP BY Q.CategoryID;


#câu 7:Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT Q.Content, Q.QuestionID, EQ.ExamID, COUNT(EQ.QuestionID) AS SL
FROM `Question` Q
LEFT JOIN `ExamQuestion` EQ ON EQ.QuestionID = Q.QuestionID
GROUP BY Q.QuestionID;

#câu 8: Lấy ra Question có nhiều câu trả lời nhất
WITH CTE_SLSDQ AS
(SELECT Q.Content, COUNT(AR.QuestionID) AS SLA
FROM `Question` Q
LEFT JOIN `Answer` AR ON Q.QuestionID = AR.QuestionID
GROUP BY Q.QuestionID)

SELECT * FROM CTE_SLSDQ
WHERE SLA = (SELECT MAX(SLA) FROM CTE_SLSDQ);

#câu 9: Thống kê số lượng account trong mỗi group
SELECT G.GroupName, COUNT(GA.AccountID) AS SLA
FROM `Group` G
LEFT JOIN `GroupAccount` GA ON Ga.GroupID = G.GroupID
GROUP BY G.GroupID;

#câu 10: Tìm chức vụ có ít người nhất
WITH CTE_SLNg AS
(SELECT P.PositionName, COUNT(A.PositionID) AS SLNg
FROM `Position` P
JOIN `Account` A ON A.PositionID = P.PositionID
GROUP BY P.PositionID)

SELECT * FROM CTE_SLNg
WHERE SLNg = (SELECT MIN(SLNg) FROM CTE_SLNg) ;

#câu 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
SELECT P.PositionName, D.DepartmentName, COUNT(A.PositionID) AS SL
FROM `Position` P
JOIN `Account` A ON A.PositionID = P.PositionID
JOIN `Department` D ON D.DepartmentID = A.DepartmentID
GROUP BY (A.PositionID);

#câu 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, ...
SELECT Q.Content, Tq.TypeName, A.FullName, AR.Content
FROM `Question` Q
JOIN `TypeQuestion` TQ ON TQ.TypeID = Q.TypeID
JOIN `Account` A ON A.AccountID = Q.CreatorID
LEFT JOIN `Answer` AR ON AR.QuestionID = Q.QuestionID;

#Câu 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT TQ.TypeName, COUNT(Q.TypeID) AS SL
FROM `TypeQuestion` TQ
JOIN `Question` Q ON Q.TypeID = TQ.TypeID
GROUP BY TQ.TypeName;

#Câu 14: Lấy ra group không có account nào
WITH CTE_SLAc AS
(SELECT G.GroupName, COUNT(GA.GroupID) AS SLA
FROM `Group` G
LEFT JOIN `GroupAccount` GA ON Ga.GroupID = G.GroupID
GROUP BY G.GroupID)

SELECT * FROM CTE_SLAc
WHERE SLA = (SELECT MIN(SLA) FROM CTE_SLac);

#câu 16: Lấy ra question không có answer nào
WITH CTE_SLAr AS
(SELECT Q.Content, COUNT(AR.QuestionID) AS SL_Answer
FROM `Question` Q
LEFT JOIN `Answer` AR ON Q.QuestionID = AR.QuestionID
GROUP BY Q.QuestionID)

SELECT * FROM CTE_SLAr
WHERE SL_Answer = (SELECT MIN(SL_Answer) FROM CTE_SLAr);




#Câu 17:

SELECT A.FullName
FROM `Account` A
JOIN `GroupAccount` GA ON GA.AccountID = A.AccountID
WHERE GroupID = 1

UNION

SELECT A.FullName
FROM `Account` A
JOIN `GroupAccount` GA ON GA.AccountID = A.AccountID
WHERE GroupID = 2;


#Câu 18:
SELECT G.GroupName, COUNT(GA.AccountID) AS SLA
FROM `Group` G
JOIN `GroupAccount` GA ON Ga.GroupID = G.GroupID
GROUP BY G.GroupID
HAVING SLA > 1
UNION ALL
SELECT G.GroupName, COUNT(GA.AccountID) AS SLA
FROM `Group` G
JOIN `GroupAccount` GA ON Ga.GroupID = G.GroupID
GROUP BY G.GroupID
HAVING SLA < 5;



