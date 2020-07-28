delimiter $$

create procedure fetchPhoneList(inout list varchar(500))
begin
	declare phoneNumber varchar(20);
	declare done int default 0;
	# ��������� ������
	# ���� � ���������/������� ��������� ������ ����������, �� ��� ������ ���� ���������� �� ���������� �������
	declare cur cursor for select phone from contacts;
	# ��������� ���������� ������ ������� ��������� � ��� ������, ���� ������ �� ������ ����� ����� ������
	declare continue handler for not found set done = 1;

	# open - ��������� ������(�������� ���������� ��������� select)
	open cur;

	# loop - ����������� ����,getPhones - ��� �����
	getPhones: loop
	# fetch - �������� ���� ������ �� ������� � ��������� �� ���������
		fetch cur into phoneNumber;
		if done = 1 then 
			leave getPhones;
		end if;
		set list = concat(phoneNumber, ', ',  list);
	end loop getPhones;

	#close - ��������� ������(������� ��� �� ������)
	close cur;
end
$$