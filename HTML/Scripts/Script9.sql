# функции для работы со строками

# concat - объеденяет строки в одну
select concat('Hello', ' ', 'world');

# concat_ws - объеденяет строки в одну,при помощи разделителя
select concat_ws('__','Hello', ' ', 'world');

# length - возвращает длинну строки
select length ('hello');

# trim - даляет все пробелы из начала и конца строки
# rtrim - удаляет пробелы с конца строки
# ltrim - удаляет пробелы с начала строки
select 
	trim('    hay  '),
	rtrim(' hay     '),
	ltrim('   hay ');

# left - вырезает из начала строки определенное кол-во символов
# right - вырезает из конца строки определенное кол-во символов
select left ('Hello world', 5), right ('Hello world', 5);

select left (name,3) from uzers;

# substring
#3 - индекс символа с которого начинается поиск подстроки
# [5] - кол-во символов в искомой подстроке
select substring('Hello world',3, 5);

# upper, lower - верхний/нижний регистр
select upper('hello'), lower('WORLD');

# repeat - дублирует строку определенное кол-во раз
select repeat ('Hello world ', 3);

# rpad - добавляет к концу строки несколько повторений другой строки
# lpad - добавляет к началу строки несколько повторений другой строки
select rpad ('Hello', 10, '!'),lpad('world', 10, '! ');

