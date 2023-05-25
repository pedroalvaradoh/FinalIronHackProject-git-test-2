# Making the Final IronHack Project
This project is a back-end API following the best practices of a REST API, it was made with Java <img src="https://icongr.am/devicon/java-original.svg?size=128&color=currentColor" height="30px" weight="30px"> and SpringBoot. This is an API where an Admin can add, update, delete, and get information
from users inscribed and interested to receive aerial classes to workout and have some fun for a while. For the moment, the Admin is the only user who has access and have permissions to
update all the info presented in the Academy.

## 📝 Instructions
It is necessary to have installed the following softwares:
- IntelliJ IDEA 
- MySQL Workbench 8.0 <img src="https://icongr.am/devicon/mysql-original.svg?size=64&color=currentColor" height="30px" weight="30px">
- Postman (an API platform for building and using APIs), this is optional, you can also use it online.

# UML cases present in the project:
<h3>UML</h3>
<img src="FINAL PROJECT UML (1).jpeg"<img src=

## 🌱 How to start this project
- 1) To start, you need to fork or clone this repository to your local repository.
- 2) Then, open the project on IntelliJ.
- 3) You have to connect your Database on MySQL Workbench 8.0 to your local server: Database> Connect to Database > Stored Connection: Local InstanceMySQL80 > Write your passwork previosly configured.
- 4) For your personal use, the password and your local server, have to be modified on the section application.properties in Java, found at: 

```sh
src/main/resources/application.properties

```
 
 ```java
spring.datasource.url=jdbc:mysql://localhost:3306/AerialApi?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=mysql123
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=create

server.error.include-stacktrace=never
server.port=8085
spring.jpa.show-sql=true
 ```

- 4) After the conection is done, you can run the project on IntelliJ, in the runnable class with the configuration Current File:

```sh
src/main/java/com/ironhack/demo/FinalIronHackProjectApplication.java
```

- 5) You can check that the tables are created at MySQL:
<img src="Screenshot 2023-05-25 174806.png">



