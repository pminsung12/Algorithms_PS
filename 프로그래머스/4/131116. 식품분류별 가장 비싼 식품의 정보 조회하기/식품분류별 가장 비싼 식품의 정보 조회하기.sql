with categorized as(
    select PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, PRICE
    from food_product
    where category in ('과자','국', '김치', '식용유')
)

select category, price max_price, product_name
from categorized c
where price = (select max(price) from categorized a where c.category=a.category)
order by price desc