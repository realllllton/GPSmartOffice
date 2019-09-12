select users_role.user_name, pass_word, users_role.id_role, role.name_role, first_name, last_name, users.email, users.images, users.activated, users.block from users INNER JOIN users_role on users.user_name = users_role.user_name
inner join role on role.id_role = users_role.id_role where 1=1
