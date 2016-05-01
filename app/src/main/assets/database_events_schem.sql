CREATE TABLE IF NOT EXISTS `events` (
  `_id` UNSIGNED INTEGER(10) NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `localization` varchar(150) DEFAULT NULL,
  `organization` varchar(150) DEFAULT NULL,
  `datetime` varchar(50) DEFAULT NULL
);


INSERT INTO events (`_id`, `title`, `description`, `localization`, `organization`, `datetime`)
VALUES ( 1, 'Title1', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. ', 'Nice', 'BDM', '01/01/2016' );

INSERT INTO events (`_id`, `title`, `description`, `localization`, `organization`, `datetime`)
VALUES ( 2, 'Title2', 'Vestibulum dictum lectus sit amet felis ullamcorper placerat. ', 'Valbonne', 'BDE', '02/02/2016' );

INSERT INTO events (`_id`, `title`, `description`, `localization`, `organization`, `datetime`)
VALUES ( 3, 'Title3', ' Nunc feugiat semper sem sed blandit. Morbi tempus diam justo. ', 'Nice', 'PolyCine', '03/02/2016' );

INSERT INTO events (`_id`, `title`, `description`, `localization`, `organization`, `datetime`)
VALUES ( 4, 'Title4', 'Proin sit amet mauris sit amet dui pulvinar tempus tempus ac magna. ', 'Nice', 'BDG', '04/04/2016' );

INSERT INTO events (`_id`, `title`, `description`, `localization`, `organization`, `datetime`)
VALUES ( 5, 'Title5', 'Suspendisse tempus, purus quis ultrices auctor.', 'Nice', 'BDC', '05/05/2016' );