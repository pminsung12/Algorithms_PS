select 
    board_id, 
    writer_id, 
    title, 
    price, 
    case used_goods_board.status 
        when "DONE" then "거래완료" 
        when "SALE" then "판매중" 
        when "RESERVED" then "예약중" end status
from used_goods_board
where created_date like '2022-10-05%'
order by board_id desc