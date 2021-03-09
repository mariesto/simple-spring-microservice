DROP TABLE IF EXISTS rating;

CREATE TABLE rating (
      id INT(11) PRIMARY KEY,
      book_id VARCHAR(250) NOT NULL,
      stars INT(11) NOT NULL
);

INSERT INTO rating(id, book_id, stars) VALUES
(1, 'ISBN-123', 5),
(2, 'ISBN-134', 4);