INSERT INTO USER (id, avatar, first_name, last_name, password, username) VALUES
(1, 'profile.jpg', 'admin', 'admin', '{bcrypt}$2y$12$sxDWzQoUs9l5HCQW.WJHEuF8cxoVx6IQbhPoN/XUaQOeTodUHmLBm', 'admin'),
(2, 'profile.jpg', 'Johny', 'Bravo', '{bcrypt}$2y$12$hiVqRQf5TMC8FXM/khQy3.mrl/kj9MK0t3G/GhXcB2lzT88ikVQh6','user'),
(3, 'profile.jpg', 'Viktor', 'Doe', '{bcrypt}$2y$12$1Qx.7C.oymFztnlVzbu07uwahlSAxk/AFCRXsslfbgzPA55bVMb..','user2'),
(4, 'profile.jpg', 'Piotr', 'Gražulevskij', '{bcrypt}$2y$12$noAXSLWsc89vWO8mfVvza./7T4r1EMnhqDoaCgtr53LKQyQR/ztAO','user3');

INSERT INTO ROLE (id, role_name) VALUES
(1, 'ADMIN'),
(2, 'USER');

INSERT INTO USER_ROLES (user_id, role_id) VALUES
(1, 1),
(1, 2),
(2, 2);

INSERT INTO POST (id, title, body, created_on, updated_on, username) VALUES
(1, 'Delfi comments review', 'Hello world and good bye', '2020-01-01 14:14', '2020-08-02 18:14', 'admin'),
(2, 'Facebook comments review', 'Goooooooood bye, gooooood bye, gooood bye', '2020-02-02 15:15', '2020-08-02 04:20', 'admin');

INSERT INTO COMMENTS (id, body, created_on, updated_on, post_id, user_id) VALUES
(1, 'Kill yourself!', '2020-01-02 15:15', '2020-03-02 14:14', 1, 3),
(2, 'Aš nesivakcinuosiu, nes FB komentaruose moteris su gėlių profilio nuotrauka, mane įtikino, kad daktarai meluoja', '2020-01-02 15:15', '2020-03-02 14:14', 1, 3),
(3, 'Šitas appsas tragiškas, nes lanzbergių klanas sunaikino kolūkius', '2020-04-20 12:15', '2020-06-12 13:01', 1, 4),
(4, 'MS teams lagina, nes Bilas Geitsas naudoja jūsų kompų resursus gaminti čipus vakcinacijai', '2020-01-13 15:15', '2020-05-02 14:14', 2, 2),
(5, 'Donald Trump will fight deepstate and will set free all child slaves from pentagon', '2020-01-02 15:15', '2020-03-02 14:14', 2, 4);

INSERT INTO POST_COMMENTS(post_id, comments_id) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(2, 5);

INSERT INTO USER_COMMENTS(user_id, comments_id) VALUES
(3, 1),
(3, 2),
(4, 3),
(2, 4),
(4, 5);