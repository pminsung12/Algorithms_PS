select 
    history_id, 
    car_id, 
    date_format(start_date, '%Y-%m-%d') start_date, 
    date_format(end_date, '%Y-%m-%d') end_date, 
    if(timestampdiff(day, start_date, end_date)>=29,'장기 대여','단기 대여') rent_type 
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date like '2022-09%'
order by history_id desc