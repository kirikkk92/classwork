delimiter $$

create procedure searchLanguage(year1 int(16), year2 int(16))
begin
	select name, author_name,creation_date,biography
	 from programming_languages inner join authors on id = language_id 
	where year(creation_date) between year1 and year2
	order by creation_date desc;
end
$$