SELECT b.category, sum(s.sales) as total_sales
from book_sales s
left join book b
on s.book_id = b.book_id
where trunc(sales_date) between date '2022-01-01' and date '2022-01-31'
group by b.category
order by b.category