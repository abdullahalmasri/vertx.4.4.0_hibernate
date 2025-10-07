# Rentcar

``the following describtion of application
customer can rent a car and then get booking info, the application need still work such as validtation and etc but for now it is simple.
``

![sparks](https://img.shields.io/badge/vert.x-4.4.4-purple.svg)
![sparks](https://mapstruct.org/images/mapstruct.png)
![sparks](https://upload.wikimedia.org/wikipedia/commons/4/41/Hibernate_logo.svg)
![sparks](https://upload.wikimedia.org/wikipedia/commons/2/29/Postgresql_elephant.svg)

#### This application was generated using [Vert.x Starter](http://start.vertx.io)

## Building
* Java 11 or higher
* Postgres Database
* Maven 3.6.8 or higher
* IDE (Eclipse,Intellij,etc)

### DATABASE
Before run the application you will need to enter your database
i use terminal since have linux OS Commands are follow :
```
sudo -i -u postgres
enter your personal password
then psql
then CREATE DATABASE hibernatedb
```

To package your application:
```
./mvnw clean package
```

To run your application:
```
./mvnw clean compile exec:java
```
To Make it Run Using Run Command on Intellij
```
select run/debug configuration
then edit configuration
after that click on + button then Application
copy io.vertx.core.Launcher and past it in field main class
copy run com.company.rentCar.MainVerticle and past it
in field Program Arguments
```

### Technologies
* (project architecture model for entities data for DTO's sql for Repository service for services and mapper to convert entity to dto and vice versa) and handler and router )
* MapStruct will generate implementations for interfaces in target generated-sources
* Facade Design Pattern to make maintenance easy
* UUID to not duplicate id's and ensure that your ID is not just unique in the context of a single database table, but is unique in the universe.
* hibernate will generate tables base on entities and create structure and help you with transaction of your Database
* CRUD-API, in class BookingRepositoryImp there is query with Join plus to create-retrieve-update-delete mostly important comment in BookingRepositoryImp

## Document and website

* [Vert.x Documentation](https://vertx.io/docs/)
* [Vert.x Stack Overflow](https://stackoverflow.com/questions/tagged/vert.x?sort=newest&pageSize=15)
* [Vert.x User Group](https://groups.google.com/forum/?fromgroups#!forum/vertx)
* [Vert.x Discord](https://discord.gg/6ry7aqPWXy)
* [jboss-doc](https://docs.jboss.org/hibernate/core/3.3/reference/en/html/batch.html#batch-direct)
* [Vert.x Gitter](https://gitter.im/eclipse-vertx/vertx-users)
* [hibernate-reactive](https://thorben-janssen.com/hibernate-reactive-getting-started-guide/)
* [hibernate](https://hibernate.org/reactive/documentation/1.0/javadocs/org/hibernate/reactive/mutiny/Mutiny.Session.html)
* [hibernate-Documentation-too-important](https://hibernate.org/reactive/documentation/1.0/reference/html_single/)
* [Mutiny](https://smallrye.io/smallrye-mutiny/2.0.0/tutorials/creating-uni-pipelines/#the-uni-type)
* [hibernate-reactive-project-github](https://github.com/hibernate/hibernate-reactive/tree/main)
* [hibernate-reactive-howto-project-github](https://github.com/vertx-howtos/hibernate-reactive-howto/blob/master/src/main/java/io/vertx/howtos/hr/MainVerticle.java)
* [mapStruct](https://www.baeldung.com/mapstruct)
* [Future-doc](https://www.baeldung.com/guava-futures-listenablefuture)
* [Logger-Doc-if-needed](https://guozheng-ge.medium.com/logging-with-vert-x-part-1-c80eaae003f2)
* [another-vert.x-project](https://git.yurimednikov.xyz/yuri/vertx-hibernate-tutorial-old/src/branch/master)
* [guide-crud-api](https://thorben-janssen.com/hibernate-reactive-getting-started-guide/)


[10/5, 7:53 PM] Träumer Informatiker ISO: curl --location --request POST 'http://localhost:9000/api/auth/logout' \
--header 'Authorization: Bearer eyJraWQiOiJkODljNmI3ZS02Mjg5LTQyMDAtOWEzYi1iMmE0NzExMjlhOTQiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJzdXBlcmFkbWluIiwiYXVkIjoiaGF3a2FtYS1jbGllbnQiLCJuYmYiOjE3NTk2MDg4NTMsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiXSwicm9sZXMiOlsiUk9MRV9TVVBFUkFETUlOIl0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6OTAwMCIsImV4cCI6MTc1OTYwOTE1MywiaWF0IjoxNzU5NjA4ODUzLCJqdGkiOiJhMGY1ZTc2YS03YTNjLTRiODUtOTE2Yi1mYTEzNzNmYzA0OTIifQ.QNzbYi2E8IyYY-Sf-i7av13jT7jXn8xvstbJWji0SorAO_WmZpoQugn0JlroJQtDTg6cVPj-U4DxWAbhvtYI7BtMjZ54Dxs5S-GiOJKHpoXSPe6F1u3zbELL9mj0172G8K3_J7AuOI2lu-WmvS3su0wJ4G_n0hOIv7mze-ImII7U9yWzk7ZIwM5BWaXakXldb0XjXnMJGQgm2KvxINloKsad_h903GDLG9qbeRqhxDnmRw21dfb1kOkMBtGTh7SewTFCEWHCtMJDo8c59VSQZ5fT616y7nbDX2qVNPPY--WwW0UgynCwOn6KtD6iGQKUdMD5JZz4-JmrC33lpUQh2w' \
--header 'Content-Type: application/json' \
--header 'X-XSRF-TOKEN: <XSRF-TOKEN-from-cookies.txt>' \
--header 'Cookie: cookies.txt; JSESSIONID=136B9424832E6CD10E3D15EFF958B4A5'
[10/5, 7:54 PM] Träumer Informatiker ISO: curl --location 'http://localhost:9000/api/auth/login' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=136B9424832E6CD10E3D15EFF958B4A5; access_token=eyJraWQiOiJkODljNmI3ZS02Mjg5LTQyMDAtOWEzYi1iMmE0NzExMjlhOTQiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJzdXBlcmFkbWluIiwiYXVkIjoiaGF3a2FtYS1jbGllbnQiLCJuYmYiOjE3NTk2MDg4NTMsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiXSwicm9sZXMiOlsiUk9MRV9TVVBFUkFETUlOIl0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6OTAwMCIsImV4cCI6MTc1OTYwOTE1MywiaWF0IjoxNzU5NjA4ODUzLCJqdGkiOiJhMGY1ZTc2YS03YTNjLTRiODUtOTE2Yi1mYTEzNzNmYzA0OTIifQ.QNzbYi2E8IyYY-Sf-i7av13jT7jXn8xvstbJWji0SorAO_WmZpoQugn0JlroJQtDTg6cVPj-U4DxWAbhvtYI7BtMjZ54Dxs5S-GiOJKHpoXSPe6F1u3zbELL9mj0172G8K3_J7AuOI2lu-WmvS3su0wJ4G_n0hOIv7mze-ImII7U9yWzk7ZIwM5BWaXakXldb0XjXnMJGQgm2KvxINloKsad_h903GDLG9qbeRqhxDnmRw21dfb1kOkMBtGTh7SewTFCEWHCtMJDo8c59VSQZ5fT616y7nbDX2qVNPPY--WwW0UgynCwOn6KtD6iGQKUdMD5JZz4-JmrC33lpUQh2w; refresh_token=-vTFE2W-zRAxz5KHJqOuqReTSzm0fk_T2RymXviw563zDUnaE2UszpxC94QR38Bebk73GNAylalLwh-BvFbcG7p44CCiRd7PoWOBFsfjuC64mgPOpg7Os_L7Bqri2IZu' \
--data '{"username":"superadmin","password":"superadmin123"}'
