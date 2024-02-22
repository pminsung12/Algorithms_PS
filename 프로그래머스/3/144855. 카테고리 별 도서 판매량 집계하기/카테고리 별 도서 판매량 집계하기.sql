select b.category, sum(sales) total_sales
from book b
join book_sales s
on b.book_id=s.book_id
where s.sales_date like '2022-01%'
group by category
order by category