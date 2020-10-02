delimiter $$ 

create procedure uzersB()
begin
	select * from uzers where name like 'V%';
end
$$