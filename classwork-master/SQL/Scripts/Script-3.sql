delimiter $$

# in - �������� ������ �������� � ���� ���������
# out - ������� ����� ������ ������ ������ ���� ���������
# inout - �������� ������������� ������ ���� ��������� � ��� �� �������� �����
# set - ����������� ��� ���������� �������� ������������
create procedure summ(in a int, in b int, inout res int) 
begin
	set res = a + b;
end
$$