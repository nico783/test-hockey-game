INSERT INTO player(number, name, lastname, position)
VALUES (31, 'Carey', 'Price', 'goaltender'),
(14, 'Nick', 'Suzuki', 'forward'),
(15, 'Jesperi', 'Kotkaniemi', 'forward'),
(71, 'Jake', 'Evans', 'forward'),
(27, 'Alexander', 'Romanov', 'defenseman'),
(6, 'Shea', 'Weber', 'defenseman');

INSERT INTO team (id, coach, year, captain_number)
VALUES (2, 'Dominique Ducharme', 2020, 6),
       (1, 'Dominique Ducharme', 2019, 6);

INSERT INTO team_player(team_id, player_number)
VALUES (1, 31), (1, 14),(1, 15),(1, 71),(1, 27),(1, 6),
       (2, 31), (2, 14),(2, 15),(2, 71),(2, 27),(2, 6);






