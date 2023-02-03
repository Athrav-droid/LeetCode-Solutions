# Write your MySQL query statement below
select employee_id from employees emp where employee_id not in (select employee_id from salaries)
union
select employee_id from salaries sal where employee_id not in (select employee_id from employees)
order by employee_id