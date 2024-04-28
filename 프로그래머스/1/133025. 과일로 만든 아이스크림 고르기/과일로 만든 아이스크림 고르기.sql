# select ii.flavor 
# from first_half fh join icecream_info ii on fh.flavor = ii.flavor
# where ingredient_type = "fruit_based" and total_order > 3000
# order by total_order desc;

select ii.FLAVOR
from FIRST_HALF fh join ICECREAM_INFO ii 
where fh.flavor = ii.flavor and ingredient_type = "fruit_based" and total_order > 3000
order by total_order desc;