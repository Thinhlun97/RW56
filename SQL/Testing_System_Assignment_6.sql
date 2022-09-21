USE testing_system_assignment_1;

#câu 1
DROP PROCEDURE IF EXISTS SP_GetAccFromDepartName;
DELIMITER $$
	CREATE PROCEDURE SP_GetAccFromDepartName(IN DepartmentName VARCHAR(50))
    BEGIN
		SELECT A.AccountID, A.FullName, D.DepartmentName
        FROM `Account` A
        JOIN `Department` D ON D.DepartmentID = A.DepartmentID
        WHERE D.DepartmentName = DepartmentName;
    END $$
DELIMITER ;

CALL SP_GetAccFromDepartName('Sale');
CALL SP_GetAccFromDepartName('No person');
CALL SP_GetAccFromDepartName('Marketing');

#câu 2
DROP PROCEDURE IF EXISTS SP_GetCountAccountFromGroup;
DELIMITER $$
	CREATE PROCEDURE SP_GetCountAccountFromGroup(IN GroupName VARCHAR(50))
    BEGIN
		SELECT G.GroupID, G.GroupName, COUNT(GA.GroupID) AS SLA
		FROM GroupAccount GA
		JOIN `Group` G ON G.GroupID = GA.GroupID
		WHERE G.GroupName = GroupName
		GROUP BY GA.GroupID;
    END $$
DELIMITER ;

CALL SP_GetCountAccountFromGroup('Testing System');
CALL SP_GetCountAccountFromGroup('Vi Ti Ai');

#câu 3
DROP PROCEDURE IF EXISTS SP_Typequesinmonth;
DELIMITER $$
	CREATE PROCEDURE SP_Typequesinmonth()
    BEGIN
		SELECT TQ.TypeName, COUNT(Q.TypeID) AS SL
        FROM TypeQuestion TQ
        JOIN Question Q ON TQ.TypeID = Q.TypeID
        WHERE month(Q.Createdate) = month(Now) AND year(Q.Createdate) = Year(now)
        GROUP BY TQ.TypeID;
	END $$
DELIMITER ;

SELECT month(now());

call testing_system_assignment_1.SP_Typequesinmonth();

