CREATE TABLE IF NOT EXISTS Difficulty(
  			id SERIAL PRIMARY KEY,
            score INTEGER NOT NULL,
  			UNIQUE(score)
);
INSERT INTO Difficulty(score)
VALUES (100),(200),(300),(400),(500);


CREATE TABLE IF NOT EXISTS Topic(
			id SERIAL PRIMARY KEY,
            name VARCHAR(100) NOT NULL,
  			UNIQUE(name)
);
INSERT INTO Topic(name)
VALUES ('Космос'),('Культура и традиции'),('Игры'),('Великие деятели'),('Страны мира'),('Литература'),('Кино');

CREATE TABLE IF NOT EXISTS Questions(
                       id SERIAL PRIMARY KEY,
                       text VARCHAR(300) NOT NULL,
  					   answer VARCHAR(150) NOT NULL,
                       id_topic INTEGER REFERENCES topic(id),
  					   id_difficulty INTEGER REFERENCES difficulty(id),
  					   UNIQUE(text)
);





