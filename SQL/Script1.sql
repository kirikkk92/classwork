# * - все столбцы
select id, name as username, birthday
from uzers 
where id between 1 and 10

# группировка данных по столбцу
group by username
order by birthday 

# limit 10 - первые 10 записей
# limit 3, 8 - 8 записей начиная с 4
limit 1

# order by (ASC- по возрастанию, DESC -по убыванию) - сортировка по столбцу
# where name = 'Kirill' and (id = 1 or id = 5)
# where id between  1 and 15   


 