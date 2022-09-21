USE Testing_system_assignment_1;

#Cau 1

CREATE VIEW V_DSNV_SALE AS
SELECT A.*,D.DepartmentName
FROM `Account` A
JOIN `Department` D ON A.DepartmentID = D.DepartmentID
WHERE DepartmentName = 'Sale';

SELECT * FROM V_DSNV_SALE ORDER BY AccountID;

#Cau 2

CREATE VIEW V_DS_accgroup AS

WITH CTE_SLA AS (
	SELECT COUNT(AccountID) AS SL
    FROM `GroupAccount` GA
    GROUP BY AccountID)

SELECT A.*,COUNT(GA.AccountID) AS SL
FROM `GroupAccount` GA
JOIN `Account` A ON GA.AccountID = A.AccountID
GROUP BY GA.AccountID
HAVING COUNT(GA.AccountID) = (SELECT MAX(SL) FROM CTE_SLA);

#Cau 3
CREATE VIEW V_LengthContent AS
SELECT *, LENGTH(Content)
FROM `Question` Q
WHERE LENGTH(Content) > 3
ORDER BY LENGTH(Content) ;

SELECT * FROM V_LengthContent;


#Cau 4

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
    
#Cau 5

CREATE VIEW V_QuescreatebyhoNguyen AS

SELECT Q.*,A.FullName AS Creator
FROM `Question` Q
JOIN `Account` A ON Q.CreatorID = A.AccountID
WHERE SUBSTRING_INDEX( A.FullName, ' ', 1 ) = 'Nguyễn';

SELECT * FROM V_QuescreatebyhoNguyen; 

