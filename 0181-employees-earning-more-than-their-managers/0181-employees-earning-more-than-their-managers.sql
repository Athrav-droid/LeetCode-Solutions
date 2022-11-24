# Write your MySQL query statement below
select e.name as Employee from Employee e , Employee f where e.managerID = f.id and e.salary > f.salary