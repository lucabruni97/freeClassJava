CREATE TABLE IF NOT EXISTS studente
(
    id          LONG PRIMARY KEY AUTO_INCREMENT,
    nome        VARCHAR(99),
    email       VARCHAR(99),
    dataNascita date
    );

CREATE TABLE IF NOT EXISTS corso
(
    id          LONG PRIMARY KEY AUTO_INCREMENT,
    titolo      VARCHAR(99),
    descrizione VARCHAR(1000),
    dataInizio  date,
    dataFine    date
    );

CREATE TABLE IF NOT EXISTS studente_corso
(
    idCorso    long not null references corso (id),
    idStudente long not null references studente (id),
    primary key (idCorso, idStudente)
    )