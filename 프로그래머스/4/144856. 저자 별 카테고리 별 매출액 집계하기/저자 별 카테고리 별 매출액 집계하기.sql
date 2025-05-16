select a.author_id, a.author_name, b.category, sum(s.sales*b.price) as total_sales
from  book_sales s
inner join book b
on s.book_id = b.book_id
inner join author a
on b.author_id = a.author_id
where s.sales_date between date '2022-01-01' and date '2022-01-31'
group by a.author_id, a.author_name, b.category
order by a.author_id, b.category desc