#in - фильтр
select * from uzers
where name in ('Kirill','Vasya');

# not in
select * from uzers
where name not in ('Kirill','Vasya');

# between
select * from uzers
where birthday between '2000-01-01' and '2020-12-01';

# like- шаблон поиска по сроке
# % - вместо % может находитс€ любой набор символов
# _ - вместо _ находитс€ один любой символ
select * from uzers 
where name like 'V%y_';

#regexp - регул€рные выражени€
select * from uzers
where name regexp 'Vasya';

# is, is null, is not null - замена =;
select * from uzers
where name is not null;