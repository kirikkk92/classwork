# ������� ��� ������ � ������

# now - ���������� ������� ���� + ����� �������
select now();

# curdate, current_date - ���������� ������� ����
select curdate(),current_date();

#curtime,current_time - ������� �����
select curtime(),current_time();  

# ������� ��� �������� ���������� ����
select 
	year ('2020-08-07'),
	month ('2020-08-07'),
	day('2020-08-07'),
	hour ('2020-08-07 12:18:25'),
	minute ('2020-08-07 12:18:25'),
	second ('2020-08-07 12:18:25');
	
# datediff -���������� ������� ����� ����� ������ � ����
select datediff ('2020-07-21', '1992-03-03');