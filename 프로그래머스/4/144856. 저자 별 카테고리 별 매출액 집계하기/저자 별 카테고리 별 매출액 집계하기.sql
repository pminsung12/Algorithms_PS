with january_book_sales as(
    select b.book_id, b.author_id, b.category, s.sales*b.price sales_sum
    from book_sales s
    join book b
    on b.book_id=s.book_id
    where s.sales_date like '2022-01%'
),
january_sales_price as(
    select j.book_id, j.author_id, j.category, sum(sales_sum) total_sales
    from january_book_sales j
    group by j.author_id, j.category
)

select a.author_id, a.author_name, j.category, j.total_sales
from january_sales_price j
join author a
on j.author_id=a.author_id
order by a.author_id, j.category desc


