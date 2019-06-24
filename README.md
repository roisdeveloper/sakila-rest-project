Requirement :

-Java 8
-Maven 3.5
-Spring Boot 2.1.6
-PostgreSQL

1. Download and install dvdrental database example (based on https://dev.mysql.com/doc/sakila/en/)
http://www.postgresqltutorial.com/wp-content/uploads/2019/05/dvdrental.zip

2. DB Configuration :

dbname = dvdrental
username = postgresq
password = psql
schema = public

2. Compile and run the sakila-rest-project

mvn clean package && mvn spring-boot:run

2. Open the your fav browser :

Get all Data (Paging)
=====================
http://localhost:8080/api/actor/show
http://localhost:8080/api/address/show
http://localhost:8080/api/category/show
http://localhost:8080/api/city/show
http://localhost:8080/api/country/show
http://localhost:8080/api/customer/show
http://localhost:8080/api/film/show
http://localhost:8080/api/inventory/show
http://localhost:8080/api/language/show
http://localhost:8080/api/payment/show
http://localhost:8080/api/rental/show
http://localhost:8080/api/staff/show
http://localhost:8080/api/store/show


Get Data By Id
==============
http://localhost:8080/api/actor/show/{id}
http://localhost:8080/api/address/show/{id}
http://localhost:8080/api/category/show/{id}
http://localhost:8080/api/city/show/{id}
http://localhost:8080/api/country/show/{id}
http://localhost:8080/api/customer/show/{id}
http://localhost:8080/api/film/show/{id}
http://localhost:8080/api/inventory/show/{id}
http://localhost:8080/api/language/show/{id}
http://localhost:8080/api/payment/show/{id}
http://localhost:8080/api/rental/show/{id}
http://localhost:8080/api/staff/show/{id}
http://localhost:8080/api/store/show/{id}
