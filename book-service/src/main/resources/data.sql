DROP TABLE IF EXISTS book;

CREATE TABLE book (
      id VARCHAR(250) PRIMARY KEY,
      title VARCHAR(250) NOT NULL,
      author VARCHAR(250) NOT NULL
);

INSERT INTO book(id, title, author) VALUES
('ISBN-123', 'Create Book Rest', 'Amendo'),
('ISBN-134', 'Create Rating Rest', 'Amendo');