select Hour(Datetime) Hour, count(*) count
from animal_outs
where Hour(Datetime)>=9 and Hour(Datetime)<20
group by Hour
order by Hour