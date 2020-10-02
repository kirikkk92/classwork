delimiter $$

create function login(uname varchar(50),upass varchar(16))
returns int
begin
	declare c int default 0;

	select count(*) into c from uzers where `name` = uname and `pass` = upass;
	
	return c;
end
$$