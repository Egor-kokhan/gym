DROP TABLE IF EXISTS Person;
CREATE TABLE IF NOT EXISTS Person
(
    id           INTEGER AUTO_INCREMENT PRIMARY KEY COMMENT 'Уникальный идентификатор' ,
    first_name   VARCHAR(50) NOT NULL COMMENT 'Имя',
    last_name    VARCHAR(50) COMMENT 'Фамилия',
    age          INTEGER     NOT NULL COMMENT 'Возраст'
--     created_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Дата регистрации'
);
COMMENT ON TABLE Person IS 'Пользователь';

INSERT INTO Person (first_name, last_name, age) VALUES ('Egor', 'Kohan', 23);
INSERT INTO Person (first_name, last_name, age) VALUES ('Sasha', 'Myagkov', 24);

DROP TABLE IF EXISTS Gymnastic;
CREATE TABLE IF NOT EXISTS Gymnastic
(
    id          INTEGER AUTO_INCREMENT PRIMARY KEY COMMENT 'Уникальный идентификатор',
    name        VARCHAR(50) NOT NULL COMMENT 'Название упражнения',
    description VARCHAR(300) NOT NULL COMMENT 'Описание упражнения'
);
COMMENT ON TABLE Gymnastic IS 'Упражнение';

INSERT INTO Gymnastic (name, description)
VALUES ( 'Приседание со штангой', 'Мы крч приседаем, а потом встаем. И всё это время штанга на плечах, но её еще типо в руки взять можно, но это уже другое');
INSERT INTO Gymnastic (name, description)
VALUES ( 'Жим от груди', 'Мы крч лежим на скамье и опускаем штангу на грудь, а потом обратно поднимем');

-- DROP TABLE  Person_Exercise_type cascade;
-- CREATE TABLE Person_Exercise_type (
--                                       person_id INT,
--                                       exercise_type_id INT,
--                                       FOREIGN KEY (dick_id) references DICK(id),
--                                       FOREIGN KEY (pussy_id) references PUSSY(id)
-- );

-- CREATE TABLE IF NOT EXISTS Exercise_one
-- (
--     id           INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
--     exercise_id  INTEGER NOT NULL COMMENT 'Айди упражнения',
--     created_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Дата регистрации',
--     set_count    INTEGER COMMENT 'Количество подходов',
--     rep_count    INTEGER COMMENT 'Количество повторений'
-- );
-- COMMENT ON TABLE Exercise_one IS 'Упражнение в определнный день, с определенным весом, кол-вом повторений';

