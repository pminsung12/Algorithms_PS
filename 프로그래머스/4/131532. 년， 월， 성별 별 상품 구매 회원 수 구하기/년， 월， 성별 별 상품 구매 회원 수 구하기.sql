with joined as(
    select year(sales_date) year, month(sales_date) month, gender, o.user_id
    from user_info u
    join online_sale o
    on u.user_id=o.user_id
    where gender is not null
)

select year, month, gender, count(distinct user_id) users
from joined
group by year, month, gender
order by year, month, gender