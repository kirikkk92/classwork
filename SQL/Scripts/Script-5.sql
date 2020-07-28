delimiter $$

create function addTips(employeeId int, tipsDate datetime, tipsAmount int)
returns int
begin
	declare s int default 0;

	insert into tips (employee_id ,`date`, amount ) values (employeeId, tipsDate, tipsAmount);
	
	select sum(amount) into s from tips  where employee_id = employeeId;

	return s;
end
$$