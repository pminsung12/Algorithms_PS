-- 코드를 입력하세요
SELECT to_number(to_char(datetime, 'HH24')) as hour, count(*) as count
from animal_outs
where to_char(datetime, 'HH24') between '09' and '19'
group by to_char(datetime, 'HH24')
order by hour