set @list = '';

call fetchPhoneList(@list);

select @list;