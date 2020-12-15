INSERT INTO USERS (id, avatar, first_name, last_name, password, email, username) VALUES
(1, 'profile.jpg', 'admin', 'admin', 'admin', 'admin@java.com', 'admin'),
(2, 'profile.jpg', 'user', 'user', 'user', 'bb@email.io', 'user');

INSERT INTO ROLE (id, role_name) VALUES
(1, 'ADMIN'),
(2, 'USER');

INSERT INTO USER_ROLES (user_id, role_id) VALUES
(1, 1),
(2, 2),
(2, 1);

INSERT INTO POSTS (id, title, body, createdOn, updatedOn, username) VALUES
(1, 'Hello World', 'Hello world and good bye', 2020-10-12, null, 'user')