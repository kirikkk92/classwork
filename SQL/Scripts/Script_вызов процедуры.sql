# call - вызов хранимой процедуры
#call uzersB();
#call addUser('Igor', '1999-07-09');

# declare - создание переменной
# declare r int default 0;
# @ - обращение к пользовательской переменной(не системной!)
#set @r = 0;
#call summ(11, 9, @r);
#select @r;

#set @isExists = login('Vitya','4444');
#select @isexists;

#call addTips('1','2020-07-07','10');
#set @www = addTips('1','2020-09-08','20');
#select @www;

call searchLanguage(1995,2010);