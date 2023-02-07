# Write your MySQL query statement below

# wrong solution
# select a1.player_id as player_id, a1.event_date as first_login from activity a1, activity a2 where a1.player_id = a2.player_id and a1.event_date > a2.event_date 

select player_id, min(event_date) as first_login from activity group by player_id