DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  theme VARCHAR(250) NOT NULL
);