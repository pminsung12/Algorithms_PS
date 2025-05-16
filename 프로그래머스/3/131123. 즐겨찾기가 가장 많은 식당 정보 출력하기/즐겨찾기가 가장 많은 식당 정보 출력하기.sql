-- 코드를 입력하세요

with a as (
    select food_type, max(favorites) as max_fav
    from rest_info
    group by food_type
)

SELECT r.food_type, r.rest_id, r.rest_name, a.max_fav as favorites
from rest_info r
inner join a 
on r.favorites = a.max_fav and r.food_type = a.food_type
order by r.food_type desc
