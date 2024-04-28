# select PT_NO, PT_NAME, GEND_CD, AGE, ifnull(tlno, 'NONE') tlno
# from PATIENT
# where AGE<=12 and GEND_CD ='W'
# order by AGE desc, PT_NAME asc;

SELECT PT_NAME,	PT_NO,	GEND_CD,AGE,ifnull(TLNO,'NONE') as TLNO
from PATIENT
where (AGE<=12) and (GEND_CD='W')
order by AGE DESC, PT_NAME