with jules as(
    select shipment_id, flavor, sum(total_order) total
    from july
    group by flavor
), 
halves as(
    select shipment_id, flavor, sum(total_order) total
    from FIRST_HALF 
    group by flavor
)

select flavor
from halves h
join jules j
using (flavor)
order by h.total+j.total desc
limit 3