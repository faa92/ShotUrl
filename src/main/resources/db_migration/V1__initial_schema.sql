
CREATE TABLE users_links (
  id                BIGSERIAL PRIMARY KEY ,
  long_url          TEXT NOT NULL UNIQUE,
  shot_url          BIGSERIAL NOT NULL UNIQUE
);

DELETE
FROM users_links
WHERE id = 1;

INSERT INTO  users_links (long_url)
VALUES (1234);

SELECT