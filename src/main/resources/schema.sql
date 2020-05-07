CREATE TABLE IF NOT EXISTS Person
(
    id           INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    first_name   VARCHAR(50) NOT NULL COMMENT 'Имя',
    last_name    VARCHAR(50) COMMENT 'Фамилия',
    age          INTEGER     NOT NULL COMMENT 'Возраст',
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Дата регистрации'
);
COMMENT ON TABLE Person IS 'Пользователь';

CREATE TABLE IF NOT EXISTS Exercise
(
    id          INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(50) NOT NULL COMMENT 'Название упражнения',
    description TEXT        NOT NULL COMMENT 'Описание упражнения'
);
COMMENT ON TABLE Exercise IS 'Упражнение';

CREATE TABLE IF NOT EXISTS One_session
(
    id           INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    exercise_id  INTEGER NOT NULL COMMENT 'Айди упражнения',
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Дата регистрации',
    set_count    INTEGER COMMENT 'Количество подходов',
    rep_count    INTEGER COMMENT 'Количество повторений'

);
COMMENT ON TABLE One_session IS 'Упражнение в определнный день, с определенным весом, кол-вом повторений';

CREATE TABLE IF NOT EXISTS Person_House
(
    person_id INTEGER NOT NULL COMMENT 'Уникальный идентификатор человека',
    house_id  INTEGER NOT NULL COMMENT 'Уникальный идентификатор дома',

    PRIMARY KEY (person_id, house_id)
);
COMMENT ON TABLE Person_House IS 'join-таблица для связи человека и дома';

CREATE INDEX IX_Person_House_Id ON Person_House (house_id);
ALTER TABLE Person_House
    ADD FOREIGN KEY (house_id) REFERENCES House (id);

CREATE INDEX IX_House_Person_Id ON Person_House (person_id);
ALTER TABLE Person_House
    ADD FOREIGN KEY (person_id) REFERENCES Person (id);