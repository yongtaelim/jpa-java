# jpa-java

## Goals
1. jpa를 이용하여 Animal, Person 테이블 생성
2. jpa를 이용하여 select, insert, update, delete 수행

## Pre-operation
mysql setting on local host

## properties
- spring.datasource.username=root
- spring.datasource.password=sample
- spring.datasource.url=jdbc:mysql://localhost:3306/jpaTest?characterEncoding=UTF-8&serverTimezone=UTC
- spring.datasource.driver-class-name=com.mysql.jdbc.Driver
- spring.jpa.hibernate.ddl-auto=update
- spring.jpa.properties.hibernate.format_sql=true
- spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
