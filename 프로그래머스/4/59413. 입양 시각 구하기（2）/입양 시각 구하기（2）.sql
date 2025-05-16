-- 코드를 입력하세요
with cte as (
    select level-1 as hour
    from dual
    connect by level<=24
)


SELECT c.hour as hour, count(o.datetime) as count
from cte c
left join animal_outs o
on to_number(to_char(o.datetime, 'HH24')) = c.hour
group by c.hour
order by c.hour