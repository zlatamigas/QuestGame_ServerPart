CREATE TABLE IF NOT EXISTS Game_User (
  	id SERIAL PRIMARY KEY,
  	name VARCHAR(50) NOT NULL,
  	password VARCHAR(10) NOT NULL,
  	score INTEGER DEFAULT 0,
  	UNIQUE(name,password)
);