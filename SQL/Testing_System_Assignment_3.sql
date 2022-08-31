#câu 1


#câu 2
SELECT 
    *
FROM
    `department`
ORDER BY DepartmentID;

#câu 3
SELECT 
    DepartmentID
FROM
    `Department`
WHERE
    DepartmentName = 'Sale';
    
#câu 4
SELECT * FROM `Account`
WHERE LENGTH(FullName) = (SELECT MAX(LENGTH(FullName)) FROM `Account`)
ORDER BY AccountID;


#câu 5
WITH CTE_DEP3 AS(
	SELECT * FROM `Account` WHERE DepartmentID = 3
)
SELECT * FROM `CTE_DEP3`
WHERE LENGTH(FullName) = (SELECT MAX(LENGTH(FullName)) FROM `CTE_DEP3`)
ORDER BY FullName;


#Câu 6
SELECT
	GroupName,CreateDate
FROM
	`Group`
WHERE
	`CreateDate` < '2019-12-20';
    
#Câu 7
SELECT
	QuestionID
FROM
	`Answer`
GROUP BY
	QuestionID
HAVING COUNT(QuestionID) >=4;

#câu 8
SELECT
	`Code`
FROM
	`Exam`
WHERE
	Duration >=90 AND CreateDate < '2019-12-20';

#câu 9
SELECT
	*
FROM
	`Group`
ORDER BY CreateDate  DESC
LIMIT 5;


#câu 10
SELECT 
	COUNT(FullName) AS Numberofaccount
FROM 
	`Account`
WHERE
	DepartmentID = 2;
    
#câu 11
SELECT
	FullName
FROM
	`Account`
WHERE
	FullName LIKE 'D%' AND '%o';
    
SELECT (SUBSTRING_INDEX(FullName, ' ', 1)) FROM `Account`;
SELECT (SUBSTRING_INDEX(FullName, ' ', 2)) FROM `Account`;
SELECT (SUBSTRING_INDEX(FullName, ' ', 3)) FROM `Account`;

#câu 12
DELETE FROM Exam 
WHERE
    CreatDate < '2019-12-20';


#câu 13
DELETE FROM Question 
WHERE
    Content LIKE 'Câu Hỏi%';


#câu 14
UPDATE `Account` 
SET 
    FullName = 'Nguyễn Bá Lộc',
    Email = 'loc.nguyenba@vti.com.vn'
WHERE
    AccountID = 5;


#câu 15
UPDATE `GroupAccount` 
SET 
    AccountID = 5
WHERE
    GroupID = 4;