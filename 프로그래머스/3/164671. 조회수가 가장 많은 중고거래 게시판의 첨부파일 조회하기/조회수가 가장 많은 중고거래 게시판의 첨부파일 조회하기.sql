select concat('/home/grep/src/',board_id,'/',file_id,file_name,file_ext) file_path
from used_goods_board
join used_goods_file
using (board_id)
where views=(select max(views) from used_goods_board)
order by file_id desc