# Write your MySQL query statement below

select u.name as name, sum(t.amount) as balance from users u, transactions t where u.account = t.account group by t.account having sum(t.amount) >= 11000