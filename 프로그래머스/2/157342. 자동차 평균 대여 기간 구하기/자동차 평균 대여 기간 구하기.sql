select car_id, round(avg(timestampdiff(day, start_date, end_date)+1), 1) average_duration
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
having average_duration>=7
order by average_duration desc, car_id desc