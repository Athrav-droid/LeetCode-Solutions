# Write your MySQL query statement below

# select customer_number from orders group by customer_number having count(customer_number) >= all(select count(customer_number) from orders group by customer_number)

SELECT
    customer_number
FROM
    orders
GROUP BY customer_number
ORDER BY COUNT(*) DESC
LIMIT 1