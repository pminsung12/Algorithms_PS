with a as (
    select u.user_id, sum(b.price) as total_sales
    from USED_GOODS_BOARD b
    join USED_GOODS_USER u
    on b.writer_id = u.user_id
    where b.status = 'DONE'
    group by u.user_id
    having sum(b.price)>=700000
)

-- 코드를 입력하세요
SELECT distinct a.user_id, u.nickname, a.total_sales
from USED_GOODS_BOARD b
join a
on b.WRITER_ID = a.user_id
join USED_GOODS_USER u
on a.USER_ID = u.user_id
order by a.total_sales
