with cte as (select animal_id, i.name, timestampdiff(day, i.datetime, o.datetime) timediff
from animal_ins i
join animal_outs o
using (animal_id)
order by timediff desc
limit 2)

select animal_id, name
from cte
