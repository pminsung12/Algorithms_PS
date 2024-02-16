select ANIMAL_ID, NAME
from ANIMAL_INS
where INTAKE_CONDITION != 'aged'
order by ANIMAL_ID