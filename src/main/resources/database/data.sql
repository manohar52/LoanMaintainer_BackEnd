DELETE FROM `transaction`;
DELETE from `user`;
INSERT INTO `user` (`user_id`, `first_name`, `last_name`, `password`, `user_name`) 
			VALUES ('1', 'raj', 'sharma', 'root', 'raj12'),
				    ('2', 'sam', 'sharma', 'root', 'sam12'),
					('3', 'kaum', 'sharma', 'root', 'karim12');
INSERT INTO `transaction` (`transaction_id`, `amount`, `currency`, `receiver`, `sender`, `status_id`) VALUES (1, '100', 'USD', 1, 2, 1);
INSERT INTO `transaction` (`transaction_id`, `amount`, `currency`, `receiver`, `sender`, `status_id`) VALUES (2, '100', 'USD', 2, 1, 3);
