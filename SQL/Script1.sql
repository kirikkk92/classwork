# * - ��� �������
select id, name as username, birthday
from uzers 
where id between 1 and 10

# ����������� ������ �� �������
group by username
order by birthday 

# limit 10 - ������ 10 �������
# limit 3, 8 - 8 ������� ������� � 4
limit 1

# order by (ASC- �� �����������, DESC -�� ��������) - ���������� �� �������
# where name = 'Kirill' and (id = 1 or id = 5)
# where id between  1 and 15   


 