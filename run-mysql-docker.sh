mkdir -p /tmp/local-mysql
docker container rm -f local-mysql
docker run -d --name local-mysql -v /tmp/local-mysql:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD="admin" -e MYSQL_PASSWORD="admin" -e MYSQL_USER=admin -e MYSQL_DATABASE=ecommerce mysql:5.7

