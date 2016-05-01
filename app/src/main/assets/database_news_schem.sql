CREATE TABLE IF NOT EXISTS `news` (
  `_id` UNSIGNED INTEGER(10) NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `image_url` varchar(150) DEFAULT NULL,
  `datetime` varchar(50) DEFAULT NULL
);


INSERT INTO news (`_id`, `title`, `content`, `image_url`, `datetime`)
VALUES ( 1, 'News Title 1', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Nunc feugiat semper sem sed blandit. Morbi tempus diam justo, quis accumsan odio interdum ac. Aenean volutpat in nisi eget scelerisque. Maecenas velit mi, commodo ac lectus et, convallis congue magna. Cras sed mauris sed nisl imperdiet vehicula. Integer vehicula orci sed nunc mattis luctus. Maecenas id dolor justo. Proin sit amet mauris sit amet dui pulvinar tempus tempus ac magna.', 'http://static1.squarespace.com/static/55ae7d08e4b0d41522af009e/t/564e2656e4b01cc50dbc59a5/1447962198944/New-icon.png', '01/01/2016' );

INSERT INTO news (`_id`, `title`, `content`, `image_url`, `datetime`)
VALUES ( 2, 'News Title 2', 'Proin eu rhoncus velit, nec imperdiet dolor. Nunc in lorem sed ipsum auctor viverra. Maecenas accumsan nisl a porttitor egestas. Aenean fermentum, massa eu scelerisque vestibulum, diam dolor ultrices felis, sed cursus quam sem nec odio. Duis convallis mi et enim feugiat tincidunt. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vehicula orci sed nunc mattis luctus. Integer vehicula orci sed nunc mattis luctus. ', 'http://static1.squarespace.com/static/55ae7d08e4b0d41522af009e/t/564e2656e4b01cc50dbc59a5/1447962198944/New-icon.png', '02/02/2016' );

INSERT INTO news (`_id`, `title`, `content`, `image_url`, `datetime`)
VALUES ( 3, 'News Title 3', 'Nunc feugiat semper sem sed blandit. Morbi tempus diam justo.  Nunc in lorem sed ipsum auctor viverra. Maecenas accumsan nisl a porttitor egestas. Aenean fermentum, massa eu scelerisque vestibulum, diam dolor ultrices felis, sed cursus quam sem nec odio. Aenean volutpat in nisi eget scelerisque. Maecenas velit mi, commodo ac lectus et, convallis congue magna. Cras sed mauris sed nisl imperdiet vehicula. Integer vehicula orci sed nunc mattis luctus. ', 'http://static1.squarespace.com/static/55ae7d08e4b0d41522af009e/t/564e2656e4b01cc50dbc59a5/1447962198944/New-icon.png', '03/02/2016' );

INSERT INTO news (`_id`, `title`, `content`, `image_url`, `datetime`)
VALUES ( 4, 'News Title 4', 'Nunc feugiat semper sem sed blandit. Morbi tempus diam justo.  Nunc in lorem sed ipsum auctor viverra. Maecenas accumsan nisl a porttitor egestas. Aenean fermentum, massa eu scelerisque vestibulum, diam dolor ultrices felis, sed cursus quam sem nec odio. Aenean volutpat in nisi eget scelerisque. Maecenas velit mi, commodo ac lectus et, convallis congue magna. Cras sed mauris sed nisl imperdiet vehicula. Integer vehicula orci sed nunc mattis luctus. ', 'http://static1.squarespace.com/static/55ae7d08e4b0d41522af009e/t/564e2656e4b01cc50dbc59a5/1447962198944/New-icon.png', '04/04/2016' );

INSERT INTO news (`_id`, `title`, `content`, `image_url`, `datetime`)
VALUES ( 5, 'News Title 5', 'Consectetur adipiscing elit. Nulla facilisi.  Proin eu rhoncus velit, nec imperdiet dolor.  Nunc in lorem sed ipsum auctor viverra. Maecenas accumsan nisl a porttitor egestas. Aenean fermentum, massa eu scelerisque vestibulum, diam dolor ultrices felis, sed cursus quam sem nec odio. Aenean volutpat in nisi eget scelerisque. Maecenas velit mi, commodo ac lectus et, convallis congue magna. Cras sed mauris sed nisl imperdiet vehicula. Integer vehicula orci sed nunc mattis luctus. ', 'http://static1.squarespace.com/static/55ae7d08e4b0d41522af009e/t/564e2656e4b01cc50dbc59a5/1447962198944/New-icon.png', '04/04/2016' );
