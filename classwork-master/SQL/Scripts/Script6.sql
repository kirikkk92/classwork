use test;
# ������������ �������
# sum - �������� ��������� �������� �� ��������
select sum(id) from uzers;

#AVG - ������� �������. �������� �� �������
select avg(id) from uzers;

#Count - ������� ���-�� �������
select count(*) from uzers; 

#Min/Max - ����������� � ������������ �������� � �������
select min(birthday) from uzers;
select max(birthday) from uzers;

select count(*) as uzers_count, max(birthday) as max_bday, min(birthday) as min_bday
from uzers;