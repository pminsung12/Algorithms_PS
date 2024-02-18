select ingredient_type, sum(total_order) total_order
from first_half f
join icecream_info i
on f.flavor=i.flavor
group by ingredient_type
order by total_order