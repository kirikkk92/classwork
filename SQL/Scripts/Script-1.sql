# case 
select id, name,
case
	when year(curdate()) - year(birthday) >= 18 then '18+'
	else '�����!'
end as status
from uzers;

# if
select user_id,
if(left(phone, 4) = '+375','BY', 'not BY') as country
from contacts;

# ifnull(<�������>,<�������� ��� ������ ���� ������� �������� = null>) 
select ifnull(birthday,'��� ��� ��������') as bday from uzers;

#coalesce - ���������� ������ �� ������� ��������
select  coalesce(null,name,'hello') as qqq from uzers;