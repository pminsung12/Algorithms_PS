select animal_id, i.name
from animal_ins i
join animal_outs o
using (animal_id, animal_type, name)
order by timestampdiff(day, i.datetime, o.datetime) desc
limit 2