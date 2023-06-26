

INSERT INTO  users_links (long_url)
VALUES ('QWERTY');


CREATE TABLE users_links (
id          BIGSERIAL PRIMARY KEY,
long_url    TEXT NOT NULL UNIQUE,
shot_url    TEXT NOT NULL UNIQUE DEFAULT substr(md5(random()::text || clock_timestamp()::text), 1, 5)
);

SELECT  shot_url
FROM    users_links
WHERE   long_url = 'QWERTY';

DELETE FROM users_links
WHERE long_url = 'QWERTY';

SELECT *
FROM users_links;

