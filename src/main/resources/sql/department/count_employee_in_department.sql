select d.id_department, count(e.id_department) as count_employee, d.name_department
from departments d
LEFT JOIN employee e on e.id_department = d.id_department
WHERE 1 = 1

