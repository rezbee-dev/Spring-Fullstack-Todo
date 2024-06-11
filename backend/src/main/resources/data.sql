INSERT INTO country (name) VALUES ('USA');
INSERT INTO country (name) VALUES ('France');
INSERT INTO country (name) VALUES ('Brazil');
INSERT INTO country (name) VALUES ('Italy');
INSERT INTO country (name) VALUES ('Canada');
-- Todo Category Items
INSERT INTO category (category) VALUES ('Category 1');
INSERT INTO category (category) VALUES ('Category 2');
INSERT INTO category (category) VALUES ('Category 3');
INSERT INTO category (category) VALUES ('Category 4');
INSERT INTO category (category) VALUES ('Category 5');
INSERT INTO category (category) VALUES ('Category 6');
-- Todo Items
INSERT INTO todo (title, priority, due) VALUES ('Todo Title 1', 1, '2024-07-01 12:00:00');
INSERT INTO todo (title, priority, due, done) VALUES ('Todo Title 2', 2, '2024-07-01 2:00:00', true);
INSERT INTO todo (title, priority, due, done) VALUES ('Todo Title 3', 3, '2024-07-02 2:00:00', true);
INSERT INTO todo (title, priority, due, done) VALUES ('Todo Title 4', 1, '2024-06-01 3:00:00', true);
INSERT INTO todo (title, priority, due, done) VALUES ('Todo Title 5', 2, '2024-06-01 9:00:00', false);
INSERT INTO todo (title, priority, due, done) VALUES ('Todo Title 6', 3, '2024-07-04 2:00:00', true);
INSERT INTO todo (title, priority, due, done) VALUES ('Todo Title 7', 1, '2023-07-01 2:00:00', true);
INSERT INTO todo (title, priority, due, done) VALUES ('Todo Title 8', 2, '2024-02-01 2:00:00', false);
INSERT INTO todo (title, priority, due, done) VALUES ('Todo Title 9', 3, '2024-07-01 2:00:00', true);
INSERT INTO todo (title, priority, due, done) VALUES ('Todo Title 10', 1, '2024-03-01 18:00:00', true);
INSERT INTO todo (title, priority, due, done) VALUES ('Todo Title 11', 2, '2024-07-04 5:00:00', true);
INSERT INTO todo (title, priority, due, done) VALUES ('Todo Title 12', 3, '2024-01-01 4:00:00', false);
INSERT INTO todo (title, priority, due, done) VALUES ('Todo Title 13', 1, '2024-04-03 2:00:00', true);
--- Todo_Category items
INSERT INTO todo_category (todo_id, category_id) VALUES (1,1);
INSERT INTO todo_category (todo_id, category_id) VALUES (2,2);
INSERT INTO todo_category (todo_id, category_id) VALUES (1,3);
INSERT INTO todo_category (todo_id, category_id) VALUES (3,4);
INSERT INTO todo_category (todo_id, category_id) VALUES (4,5);
INSERT INTO todo_category (todo_id, category_id) VALUES (5,6);
INSERT INTO todo_category (todo_id, category_id) VALUES (6,1);
INSERT INTO todo_category (todo_id, category_id) VALUES (7,2);
INSERT INTO todo_category (todo_id, category_id) VALUES (8,3);
INSERT INTO todo_category (todo_id, category_id) VALUES (9,4);
INSERT INTO todo_category (todo_id, category_id) VALUES (11,5);
INSERT INTO todo_category (todo_id, category_id) VALUES (12,6);
INSERT INTO todo_category (todo_id, category_id) VALUES (13,1);

