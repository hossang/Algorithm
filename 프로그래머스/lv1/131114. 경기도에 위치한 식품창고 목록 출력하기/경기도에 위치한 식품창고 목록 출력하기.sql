select warehouse_id, warehouse_name, address, if(freezer_yn is not null,freezer_yn,"N") freezer_yn
from food_warehouse
where address like "경기도%"
order by warehouse_id;