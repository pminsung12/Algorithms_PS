select 
    user_id, 
    nickname, 
    concat(city, ' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2) 전체주소, 
    concat(left(tlno, 3), '-', substring(tlno,4,4), '-', right(tlno,4)) 전화번호
from USED_GOODS_BOARD
join USED_GOODS_USER
on writer_id=user_id
group by writer_id
having count(board_id)>=3
order by user_id desc
