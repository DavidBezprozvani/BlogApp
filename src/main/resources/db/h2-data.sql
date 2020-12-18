INSERT INTO USER (id, avatar, first_name, last_name, password, username) VALUES
(1, 'profile.jpg', 'admin', 'admin', '{bcrypt}$2y$12$sxDWzQoUs9l5HCQW.WJHEuF8cxoVx6IQbhPoN/XUaQOeTodUHmLBm', 'admin'),
(2, 'profile.jpg', 'Johny', 'Bravo', '{bcrypt}$2y$12$hiVqRQf5TMC8FXM/khQy3.mrl/kj9MK0t3G/GhXcB2lzT88ikVQh6','user');

INSERT INTO ROLE (id, role_name) VALUES
(1, 'ADMIN'),
(2, 'USER');

INSERT INTO USER_ROLES (user_id, role_id) VALUES
(1, 1),
(1, 2),
(2, 2);

# INSERT INTO POSTS (id, title, body, created_nn, updated_on, username) VALUES
# (1, 'Hello World', 'Hello world and good bye', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'user');