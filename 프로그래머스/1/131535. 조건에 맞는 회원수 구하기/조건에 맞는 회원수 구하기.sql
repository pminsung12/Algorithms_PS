select count(USER_ID) USERS
from USER_INFO
where Year(JOINED)=2021 and AGE>=20 and AGE<=29