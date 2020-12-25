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

INSERT INTO POST (id, title, body, created_on, updated_on, username, user_id) VALUES
(1, 'Vaccines will save ze world',
'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididuntut labore et dolore magna aliqua. Montes nascetur ridiculus mus mauris vitae. Id aliquet risus feugiat in ante metus. At quis risus sed vulputate odio ut. Risus in hendrerit gravida rutrum quisque non tellus orci. Vitae purus faucibus ornare suspendisse sed nisi lacus. In mollis nunc sed id semper risus in hendrerit. Enim neque volutpat ac tincidunt vitae semper quis lectus. Enim sed faucibus turpis in eu mi bibendum neque. Adipiscing tristique risus nec feugiat in. Neque aliquam vestibulum morbi blandit cursus risus at ultrices. Nulla aliquet enim tortor at auctor. Pellentesque pulvinar pellentesque habitant morbi tristique. Cras semper auctor neque vitae. Sit amet consectetur adipiscing elit ut aliquam purus sit.',
 CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'admin', 1),
(2, 'Blog app is ze best',
 'Pulvinar etiam non quam lacus suspendisse faucibus. Bibendum arcu vitae elementum curabitur. Lobortis mattis aliquam faucibus purus in massa tempor nec feugiat. Habitant morbi tristique senectus et netus et malesuada fames. Leo duis ut diam quam. Risus nullam eget felis eget nunc. Diam sit amet nisl suscipit adipiscing bibendum. At ultrices mi tempus imperdiet nulla. In nisl nisi scelerisque eu ultrices vitae auctor. Cras ornare arcu dui vivamus arcu felis bibendum. Diam sollicitudin tempor id eu nisl nunc mi ipsum faucibus. Lacus suspendisse faucibus interdum posuere lorem. Risus pretium quam vulputate dignissim. Gravida cum sociis natoque penatibus et magnis. Justo nec ultrices dui sapien eget mi proin sed libero.',
 CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'admin', 1),
(3, 'Hello world is best app',
 'Pulvinar etiam non quam lacus suspendisse faucibus. Bibendum arcu vitae elementum curabitur. Lobortis mattis aliquam faucibus purus in massa tempor nec feugiat. Habitant morbi tristique senectus et netus et malesuada fames. Leo duis ut diam quam. Risus nullam eget felis eget nunc. Diam sit amet nisl suscipit adipiscing bibendum. At ultrices mi tempus imperdiet nulla. In nisl nisi scelerisque eu ultrices vitae auctor. Cras ornare arcu dui vivamus arcu felis bibendum. Diam sollicitudin tempor id eu nisl nunc mi ipsum faucibus. Lacus suspendisse faucibus interdum posuere lorem. Risus pretium quam vulputate dignissim. Gravida cum sociis natoque penatibus et magnis. Justo nec ultrices dui sapien eget mi proin sed libero.',
 CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'admin', 1);

INSERT INTO COMMENTS (id, body, created_on, updated_on, post_id, user_id) VALUES
(1, 'Tikiuos gausiu teigiamą!', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 2, 3),
(2, 'Aš nesivakcinuosiu, nes FB komentaruose moteris su gėlių profilio nuotrauka, mane įtikino, kad daktarai meluoja', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1, 4),
(3, 'Šitas appsas tragiškas, nes lanzbergių klanas sunaikino kolūkius', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1, 4),
(4, 'MS teams lagina, nes Bilas Geitsas naudoja jūsų kompų resursus gaminti čipus vakcinacijai', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 2, 2),
(5, 'Delete this app!', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 2, 4);

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