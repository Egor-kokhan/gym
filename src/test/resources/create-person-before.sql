-- create table person
delete from person;

insert into person (id, first_name, last_name, age) values
 (1,'Егор', 'Кохан', 25),
 (2,'Саша', 'Мягков', 24);

alter sequence hibernate_sequence restart with 10;