# case 
select id, name,
case
	when year(curdate()) - year(birthday) >= 18 then '18+'
	else 'ћалой!'
end as status
from uzers;

# if
select user_id,
if(left(phone, 4) = '+375','BY', 'not BY') as country
from contacts;

# ifnull(<столбец>,<значение дл€ записи если столбец оказалс€ = null>) 
select ifnull(birthday,'нет дн€ рождени€') as bday from uzers;

#coalesce - возвращает первое не нулевое значение
select  coalesce(null,name,'hello') as qqq from uzers;