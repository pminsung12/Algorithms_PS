with car_renting as (
    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where date '2022-10-16' between trunc(start_date) and trunc(end_date)
), car_dis as (
    select distinct car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
)

select d.car_id, case when r.car_id is NULL then '대여 가능' else '대여중' end as availability
from car_dis d
left join car_renting r
on d.car_id = r.car_id
order by d.car_id desc
