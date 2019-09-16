-- select distinct ur.user_name, u.images, u.email, u.first_name, u.last_name, r.name_role, u.block from users u
-- INNER JOIN users_role ur on u.user_name = ur.user_name
-- INNER JOIN role r on r.id_role = ur.id_role group by u.user_name
select distinct * from users group by user_name
