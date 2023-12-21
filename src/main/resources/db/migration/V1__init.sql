CREATE TABLE IF NOT EXISTS user1 (
    id SERIAL PRIMARY KEY,
    name1 VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    registration VARCHAR(100) NOT NULL,
    date1 DATE
    );

CREATE TABLE IF NOT EXISTS progress (
    id SERIAL PRIMARY KEY,
    score VARCHAR(100) NOT NULL,
    date1 DATE,
    user1_id INT NOT NULL,
    FOREIGN KEY (user1_id) REFERENCES user1(id)
    );

CREATE TABLE IF NOT EXISTS notification (
    id SERIAL PRIMARY KEY,
    read1 VARCHAR(100) NOT NULL,
    message VARCHAR(100) NOT NULL,
    progress_id INT NOT NULL,
    FOREIGN KEY (progress_id) REFERENCES progress(id)
    );

CREATE TABLE IF NOT EXISTS multimedia (
    id SERAIl,
    id SERIAL PRIMARY KEY,
    type1 VARCHAR(100) NOT NULL,
    URL VARCHAR(100) NOT NULL,
    user1_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user1_id) REFERENCES user1(id)
    );

