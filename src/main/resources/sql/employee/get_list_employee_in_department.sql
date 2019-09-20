select e.id_employee, e.full_name, e.images, e.email, e.phone, e.nick_skype, e.facebook_link, e.object, e.home_town, e.education, e.school, e.science, e.status, e.created, e.graduation_year, e.last_access, e.activated
from departments d
INNER JOIN employee e
where d.id_department = e.id_department
