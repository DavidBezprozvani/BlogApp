INSERT INTO USERS (id, avatar, password, email, username) VALUES
(1, 'profile.jpg', '{bcrypt}$2y$12$fQ32bokGVwHwn8PvC7Q/ROZEEMKuX97epHJlva10Px/ABEPWd2due', 'admin@java.com', 'admin'),
(2, 'profile.jpg', '{bcrypt}$2y$12$zroYgqeBBP1CE9aVnVw7bed4FIzjeiIbWO8PY9N3aGi4it12v5KQq', 'bb@email.io', 'user');

INSERT INTO ROLE (id, role_name) VALUES
(1, 'ADMIN'),
(2, 'USER');

INSERT INTO USER_ROLES (user_id, role_id) VALUES
(1, 1),
(2, 2),
(2, 1);