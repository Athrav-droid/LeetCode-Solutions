# Write your MySQL query statement below
select name from SalesPerson where name not in 
    (select sp.name from SalesPerson sp 
    left join Orders o on sp.sales_id = o.sales_id 
    left join Company c on c.com_id = o.com_id 
    where c.name = "RED")

# select name from salesperson where sales_id not in(
# select sales_id from orders where com_id IN
# (select com_id from company where name='Red') )