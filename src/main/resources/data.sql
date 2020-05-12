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
--
-- CREATE TABLE IF NOT EXISTS Exercise_type
-- (
--     id          INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
--     name        VARCHAR(50) NOT NULL COMMENT 'Название упражнения',
--     description TEXT        NOT NULL COMMENT 'Описание упражнения'
-- );
-- COMMENT ON TABLE Exercise_type IS 'Упражнение';
--
-- CREATE TABLE IF NOT EXISTS Exercise_one
-- (
--     id           INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
--     exercise_id  INTEGER NOT NULL COMMENT 'Айди упражнения',
--     created_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Дата регистрации',
--     set_count    INTEGER COMMENT 'Количество подходов',
--     rep_count    INTEGER COMMENT 'Количество повторений'
-- );
-- COMMENT ON TABLE Exercise_one IS 'Упражнение в определнный день, с определенным весом, кол-вом повторений';
--
