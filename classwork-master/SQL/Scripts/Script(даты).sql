# функции для работы с датами

# now - возвращает текущую дату + время сервера
select now();

# curdate, current_date - возвращают текущую дату
select curdate(),current_date();

#curtime,current_time - текущее время
select curtime(),current_time();  

# функции для экспорта параметров даты
select 
	year ('2020-08-07'),
	month ('2020-08-07'),
	day('2020-08-07'),
	hour ('2020-08-07 12:18:25'),
	minute ('2020-08-07 12:18:25'),
	second ('2020-08-07 12:18:25');
	
# datediff -возвращает разницу между двумя датами в днях
select datediff ('2020-07-21', '1992-03-03');