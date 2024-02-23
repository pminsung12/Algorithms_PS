select b.book_id, a.author_name, date_format(b.published_date, '%Y-%m-%d') published_date
from book b
join author a
using (author_id)
where category='경제'
order by published_date