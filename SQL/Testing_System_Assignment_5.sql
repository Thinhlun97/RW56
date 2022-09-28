USE Testing_system_assignment_1;

#câu 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE VIEW DSNV_sale AS
	SELECT A.FullName
    FROM `Account` A
    JOIN `Department` D ON D.DepartmentID = A.DepartmentID
    WHERE D.DepartmentName = 'Sale';
    
SELECT * FROM testing_system_assignment_1.dsnv_sale;


#Câu 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE VIEW Acc_thamgianhieugroup AS
#CTE
WITH CTE_SLAccingroup AS (
	SELECT GA.* ,COUNT(*) AS SL 
    FROM `GroupAccount` GA
    GROUP BY GA.AccountID)
    
SELECT A.FullName, COUNT(GA.AccountID) AS SL
FROM `Account` A
JOIN `GroupAccount` GA ON GA.AccountID = A.AccountID
GROUP BY GA.AccountID
HAVING GA.AccountID = (SELECT MAX(SL) FROM CTE_SLAccingroup);

#Subquery
SELECT 
    A.FullName
FROM
    `Account` A
WHERE
    EXISTS( SELECT 
            *
        FROM
            `GroupAccount` GA
        WHERE
            A.AccountID = GA.AccountID
        GROUP BY GA.AccountID
        HAVING COUNT(GA.AccountID) = (SELECT 
                MAX(c)
            FROM
                (SELECT 
                    COUNT(GA.AccountID) AS c
                FROM
                    `GroupAccount` GA
                GROUP BY GA.AccountID) Test));


#Câu 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó điREATE VIEW 
CREATE VIEW V_LengthContent AS
SELECT *, LENGTH(Content)
FROM `Question` Q
WHERE LENGTH(Content) > 3
ORDER BY LENGTH(Content) ;

SELECT * FROM V_LengthContent;



#Cau 4 Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất

CREATE VIEW V_DSDEP_MAXNV AS

WITH CTE_SLNV AS (
	SELECT COUNT(DepartmentID) AS SL
    FROM `Account` A
    GROUP BY DepartmentID)
    
SELECT D.DepartmentName,COUNT(A.DepartmentID) AS SL
FROM `Department` D
JOIN `Account` A ON D.DepartmentID = A.DepartmentID
GROUP BY A.DepartmentID
HAVING COUNT(A.DepartmentID) = (SELECT MAX(SL) FROM CTE_SLNV);

SELECT * FROM V_DSDEP_MAXNV;
    
#Cau 5 Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo

CREATE VIEW V_QuescreatebyhoNguyen AS

SELECT Q.*,A.FullName AS Creator
FROM `Question` Q
JOIN `Account` A ON Q.CreatorID = A.AccountID
WHERE SUBSTRING_INDEX( A.FullName, ' ', 1 ) = 'Nguyễn';

SELECT * FROM V_QuescreatebyhoNguyen; 

