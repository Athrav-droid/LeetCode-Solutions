# Write your MySQL query statement below

select  u.name as name, sum(r.distance) as travelled_distance from Users u,Rides r where u.id=r.user_id group by r.user_id 
UNION select name, 0 as travelled_distance from users where id NOT IN (select user_id from Rides) order by travelled_distance desc, name asc;
