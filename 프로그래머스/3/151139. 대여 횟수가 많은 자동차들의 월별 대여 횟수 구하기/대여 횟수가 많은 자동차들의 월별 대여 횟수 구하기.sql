with record as
(
select month(start_date) month, car_id
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where date_format(start_date, '%Y-%m') between '2022-08' and '2022-10'
)

select r.month, r.car_id, count(*) records
from record r 
where (select count(*) from record e where r.car_id=e.car_id ) >=5
group by r.month, r.car_id
order by r.month, r.car_id desc