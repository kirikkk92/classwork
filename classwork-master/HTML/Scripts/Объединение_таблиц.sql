select u.id as userID, name, phone
from uzers u inner join contacts c on u.id = c.user_id 
where month (birthday) = 03;