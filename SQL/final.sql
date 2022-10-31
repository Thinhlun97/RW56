#cau 2
-- A) get luong thang 1 cua 1 user bat ki

SELECT U.ID , S.total_salary
FROM salary S
JOIN user_role UR ON UR.ID = S.user_role_id
JOIN user_department UD ON UD.ID = UR.user_department_id
JOIN `User` U ON U.ID = UD.user_id
WHERE S.month = 1;

-- B) Get danh sách lương tháng 5 của 1 phòng bất kì sắp xếp theo tổng lương giảm dần
SELECT D.`Name` , S.total_salary
FROM salary S
JOIN user_role UR ON UR.ID = S.user_role_id
JOIN user_department UD ON UD.ID = UR.user_department_id
JOIN `department` D ON D.ID = UD.user_id
WHERE S.month = 1 AND UD.department_id = 2
ORDER BY S.total_salary DESC;


-- c) Get nhưng user bị tính lương sai(total_salary != total detail salary) trong tháng 1/2020
SELECT UD.user_id, UD.ID, S.ID, S.total_salary AS Tong_luong1, V.total_amount AS tong_luong2
FROM salary S
JOIN v_total_amount_2 V ON V.Salary_ID = S.ID
JOIN user_role UR ON UR.ID = S.user_role_id
JOIN user_department UD ON UD.ID = UR.user_department_id
WHERE S.month = 1 AND S.total_salary != V.total_amount;

-- 3 Viết thủ tục cho phép get chi tiết lương tháng của 1 user bất kì
-- hiển thị thông tin sau: Type, Amount, Operation; sao cho hàng
-- cuối cùng sẽ là cột tổng

SELECT U.ID, U.First_name, U.Last_name, SDT.Name, Sd.Amount, SD.Operation
FROM `User` U
JOIN user_department UD ON UD.user_ID = U.ID
JOIN user_role UR ON UR.user_department_id = UD.ID
JOIN salary S ON S.user_role_id = UR.ID
JOIN salary_detail SD ON SD.salary_id = S.ID
JOIN salary_detail_type SDT ON SDT.ID = SD.salary_detail_type_id;


