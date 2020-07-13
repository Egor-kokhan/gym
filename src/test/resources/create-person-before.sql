-- create table person

delete
from visit;

delete
from training;

delete
from person;

insert into person (id, first_name, last_name, age)
values (1, 'Egor', 'Kohan', 25),
       (2, 'Sasha', 'Myagkov', 24);

alter sequence hibernate_sequence restart with 10;



insert into training (id, name, description)
values (1, 'Day of legs', 'Day of legs, exactly'),
       (2, 'Day of hand', 'Day of hand, exactly');


insert into visit (id, creation_date_time, person_id, training_id)
values (1, '2020-08-23T18:25:43.511Z', 1, 1),
       (2, '2020-10-23T18:25:43.511Z', 1, 2);