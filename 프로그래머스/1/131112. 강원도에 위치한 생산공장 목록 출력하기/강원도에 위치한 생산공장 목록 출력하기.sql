# select factory_id, factory_name, address
# from food_factory
# where address like "강원도%"
# order by factory_id asc;

select FACTORY_ID, FACTORY_NAME, ADDRESS
from FOOD_FACTORY
where address like '강원도%'
order by factory_id asc;