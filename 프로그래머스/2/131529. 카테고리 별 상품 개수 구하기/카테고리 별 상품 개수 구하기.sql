select left(product_code, 2) CATEGORY, count(*)PRODUCTS
from PRODUCT
group by category 
order by PRODUCT_CODE