with record as
(
select month(start_date) month, car_id
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where date_format(start_date, '%Y-%m') between '2022-08' and '2022-10'
)

select r.month, r.car_id, count(*) records
from record r 
where car_id in (select car_id from record group by car_id having count(*)>=5)
group by r.month, r.car_id
order by r.month, r.car_id desc