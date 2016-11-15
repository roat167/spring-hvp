create database if not exists hvp_temp//
use hvp_temp//
drop procedure if exists hvp_temp.drop_user_if_exists//

create procedure hvp_temp.drop_user_if_exists()
begin
	declare counting int default 0;
	select count(*) into counting from mysql.user where User = 'hvp' and Host = 'localhost';
	if counting > 0 then
		drop user 'hvp'@'localhost';
	end if;
end//
call hvp_temp.drop_user_if_exists()//

drop procedure if exists hvp_temp.drop_user_if_exists//
drop database if exists hvp_temp//