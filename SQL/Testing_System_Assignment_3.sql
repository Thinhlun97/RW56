USE testing_system_assignment_1;

#câu 2: lấy ra tất cả phòng ban
SELECT * FROM `Department`;

#câu 3: lấy ra phòng ban 'Sale'
SELECT * 
FROM `Department` 
WHERE DepartmentName = 'Sale';

#câu 4: lấy ra thông tin account có full name dài nhất
SELECT * FROM `Account`
WHERE LENGTH(FullName) = (SELECT MAX(LENGTH(FullName)) FROM `Account`)
ORDER BY AccountID;



#câu 5: lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3
WITH CTE_DEP3 AS(
	SELECT * FROM `Account` WHERE DepartmentID = 3
)
SELECT * FROM `CTE_DEP3`
WHERE LENGTH(FullName) = (SELECT MAX(LENGTH(FullName)) FROM `CTE_DEP3`)
ORDER BY FullName;


#câu 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT GroupName
FROM `Group`
WHERE CreateDate < '2019-12-20';


#câu 7: lấy ra ID của question có >=4 câu trả lời
SELECT *,QuestionID
FROM `Answer`
GROUP BY QuestionID
HAVING COUNT(QuestionID) >= '4';


#câu 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
SELECT *
FROM `Exam`
Where Duration >= '60' AND CreateDate < '2019-12-20';


#Câu 9: Lấy ra 5 group được tạo gần đây nhất
SELECT *
FROM `Group`
ORDER BY CreateDate DESC
LIMIT 5;

#Câu 10: Đếm số nhân viên thuộc department có id = 2
SELECT COUNT(DepartmentID) AS SLNV
FROM `Account`
WHERE DepartmentID = 2;

#Câu 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT FullName
FROM `Account`
WHERE FullName LIKE 'D%' AND '%o';


#câu 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE FROM Exam 
WHERE
    CreatDate < '2019-12-20';


#câu 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
DELETE FROM Question 
WHERE
    Content LIKE 'Câu Hỏi%';


#câu 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE `Account` 
SET 
    FullName = 'Nguyễn Bá Lộc',
    Email = 'loc.nguyenba@vti.com.vn'
WHERE
    AccountID = 5;


#câu 15: update account có id = 5 sẽ thuộc group có id = 4
UPDATE `GroupAccount` 
SET 
    AccountID = 5
WHERE
    GroupID = 4;
