# Write your MySQL query statement below


# select d.name as Department, e.name as Employee, max(e.salary) as Salary from employee e, department d where e.departmentId = d.id group by e.departmentId


SELECT D.name AS DEPARTMENT , E.name AS EMPLOYEE , E.salary
     FROM EMPLOYEE AS E , DEPARTMENT AS D where E.departmentId = D.id
     and E.salary = ( SELECT MAX(salary)
                        FROM EMPLOYEE
                        WHERE departmentID = E.departmentID);