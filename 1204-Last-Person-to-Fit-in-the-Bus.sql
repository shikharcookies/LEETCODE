# Write your MySQL query statement below
# Write your MySQL query statement below
select person_name from (
    select person_id, person_name, weight, turn,
    sum(weight) over w as weight_sum
    from Queue
    window w as (
        order by turn 
        rows between unbounded preceding and current row
        )
) x
where x.weight_sum <= 1000
order by x.turn desc
limit 1