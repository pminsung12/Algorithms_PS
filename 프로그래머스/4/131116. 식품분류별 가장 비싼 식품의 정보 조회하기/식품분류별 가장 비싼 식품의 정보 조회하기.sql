-- 코드를 입력하세요

with a as (
SELECT category, max(price) as max_price
from FOOD_PRODUCT
where category in ('과자', '국', '김치', '식용유')
group by category
)

SELECT f.category, a.max_price, f.product_name
from FOOD_PRODUCT f
inner join a
on a.max_price = f.price and a.category = f.category
order by a.max_price desc
