# ������� ��� ������ �� ��������

# concat - ���������� ������ � ����
select concat('Hello', ' ', 'world');

# concat_ws - ���������� ������ � ����,��� ������ �����������
select concat_ws('__','Hello', ' ', 'world');

# length - ���������� ������ ������
select length ('hello');

# trim - ������ ��� ������� �� ������ � ����� ������
# rtrim - ������� ������� � ����� ������
# ltrim - ������� ������� � ������ ������
select 
	trim('    hay  '),
	rtrim(' hay     '),
	ltrim('   hay ');

# left - �������� �� ������ ������ ������������ ���-�� ��������
# right - �������� �� ����� ������ ������������ ���-�� ��������
select left ('Hello world', 5), right ('Hello world', 5);

select left (name,3) from uzers;

# substring
#3 - ������ ������� � �������� ���������� ����� ���������
# [5] - ���-�� �������� � ������� ���������
select substring('Hello world',3, 5);

# upper, lower - �������/������ �������
select upper('hello'), lower('WORLD');

# repeat - ��������� ������ ������������ ���-�� ���
select repeat ('Hello world ', 3);

# rpad - ��������� � ����� ������ ��������� ���������� ������ ������
# lpad - ��������� � ������ ������ ��������� ���������� ������ ������
select rpad ('Hello', 10, '!'),lpad('world', 10, '! ');

