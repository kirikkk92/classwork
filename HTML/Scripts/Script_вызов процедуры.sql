# call - ����� �������� ���������
#call uzersB();
#call addUser('Igor', '1999-07-09');

# declare - �������� ����������
# declare r int default 0;
# @ - ��������� � ���������������� ����������(�� ���������!)
set @r = 0;
call summ(11, 9, @r);
select @r;

set @isExists = login('Vitya','4444');
select @isexists;