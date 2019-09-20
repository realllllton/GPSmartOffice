select p.user_name, p.date, p.status, p.reason, p.activated
from permission p
order by p.date DESC
