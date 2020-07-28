# подзапросы
select * from uzers 
where id > (select avg(id) from uzers);

#insert into uzers(id, name, birthday) 
#values (
#(select max(id)+10 from contacts),'Ivan', '1985-10-04'
#);

# exists
select * from uzers
where not exists (select * from contacts where user_id = uzers.id);