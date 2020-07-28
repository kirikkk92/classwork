use test;

set autocommit=1;

start transaction;

update uzers set name = 'Gosha' where id = 7;

insert into uzers (name, birthday, pass ) values ('Goshaaaa1111', '1994-03-08', '122312');

rollback;
#commit - изменени€ в базе сохран€ютс€ до первой ошибки транзакции
#rollback - откатывает все изменени€ транзакции к первоначальноиу виду  случае возникновении ошибки
