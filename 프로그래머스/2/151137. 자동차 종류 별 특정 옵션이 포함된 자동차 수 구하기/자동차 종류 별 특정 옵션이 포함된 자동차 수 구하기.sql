-- 코드를 입력하세요
with cars as (
    select car_id, car_type
    from CAR_RENTAL_COMPANY_CAR
    where options like '%통풍시트%' or options like '%가죽시트%' or options like '%열선시트%'
)


SELECT car_type, count(*) as cars
from cars
group by car_type
order by car_type