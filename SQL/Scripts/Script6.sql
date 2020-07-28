use test;
# агрегирующие функции
# sum - сложение численных значений по столбцам
select sum(id) from uzers;

#AVG - среднее арифмет. значение по столбцу
select avg(id) from uzers;

#Count - считает кол-во записей
select count(*) from uzers; 

#Min/Max - минимальное и максимальное значение в столбце
select min(birthday) from uzers;
select max(birthday) from uzers;

select count(*) as uzers_count, max(birthday) as max_bday, min(birthday) as min_bday
from uzers;