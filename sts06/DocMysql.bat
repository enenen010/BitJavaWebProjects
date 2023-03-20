@echo off
docker run -it --rm -d -p 3306:3306 ^
-e MYSQL_ROOT_PASSWORD=mysql ^
-e MYSQL_USER=scott ^
-e MYSQL_PASSWORD=tiger ^
-e MYSQL_DATABASE=lecture ^
-v mysqlData:/var/lib/mysql ^
--name mysql8 ^
mysql