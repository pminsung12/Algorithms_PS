select animal_id, name, if(SEX_UPON_INTAKE like "%Neutered%" or SEX_UPON_INTAKE like "%Spayed%", 'O', 'X') 중성화
from animal_ins
order by animal_id