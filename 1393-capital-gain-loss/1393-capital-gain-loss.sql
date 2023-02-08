# Write your MySQL query statement below

select stock_name , sum(
    CASE 
        when operation = 'Buy' then -price
        else price
    END
) as capital_gain_loss
from stocks group by stock_name
