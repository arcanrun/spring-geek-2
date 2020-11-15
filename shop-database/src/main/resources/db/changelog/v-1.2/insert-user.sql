INSERT INTO users (name, password) VALUES
('root', '$2a$10$W9oRWeFmOT0bByL5fmAceucetmEYFg2yzq3e50mcu.CO7rUDb/poG'); -- 123456
GO
INSERT INTO users_roles (user_id,role_id) VALUES (3,1), (3,2);