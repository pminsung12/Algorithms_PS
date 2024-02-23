with recursive cte(hour) as(
    select 0 hour
    union all
    select hour+1 from cte where hour<23
)

select c.hour, count(o.animal_id) count
from cte c
left join animal_outs o
on hour(o.datetime)=c.hour
group by hour
order by hour