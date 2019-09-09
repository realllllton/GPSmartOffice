select ur.user_name, u.images, u.email, r.name_role from users u
INNER JOIN users_role ur on u.user_name = ur.user_name
INNER JOIN role r on r.id_role = ur.id_role
