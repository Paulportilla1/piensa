CREATE TABLE IF NOT EXISTS user1 (
    id SERIAL,
    name1 VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    registration VARCHAR(100) NOT NULL,
    date1 DATE
    );

CREATE TABLE IF NOT EXISTS multimedia (
    id SERAIl,
    type1 VARCHAR(100) NOT NULL,
    URL VARCHAR(100) NOT NULL,
    user1_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user1_id) REFERENCES user1(id)
);

CREATE TABLE IF NOT EXISTS game (
    id SERIAL,
    name1 VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL,
    user1_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user1_id) REFERENCES user1(id)
);

CREATE TABLE IF NOT EXISTS progress (
    id SERAIL,
    score VARCHAR(100) NOT NULL,
    dat1 DATE,
    user1_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user1_id) REFERENCES user1(id)
);

CREATE TABLE IF NOT EXISTS pnotification (
    id SERIAL,
    read1 VARCHAR(100) NOT NULL,
    menssage VARCHAR(100) NOT NULL,
    progress_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (progress_id) REFERENCES progress(id)
    );


