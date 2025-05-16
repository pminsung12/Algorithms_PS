-- 코드를 입력하세요

select extract(year from sales_date) as year, extract(month from sales_date) as month, u.gender, count(distinct o.user_id) as users
from ONLINE_SALE o
left join USER_INFO u
on o.user_id = u.user_id
where u.gender is not null
group by extract(year from sales_date), extract(month from sales_date), u.gender
order by year, month, u.gender, users