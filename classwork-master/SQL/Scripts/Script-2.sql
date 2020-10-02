delimiter $$

create procedure addUser(userName varchar(50), userBDay date)
begin
	insert into uzers (name,birthday) values(userName, userBDay);
end
$$