select mcdp_cd "진료과 코드", count(*) "5월예약건수"
from appointment
where apnt_ymd like '2022-05%'
group by MCDP_CD
ORDER BY count(*) asc , mcdp_cd asc

