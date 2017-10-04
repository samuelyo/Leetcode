select d.Name Department, e.Name Employee,e.Salary Salary 
from Employee e, Department d
where e.DepartmentId = d.Id and 3 > ( select count(distinct(e2.Salary)) from Employee e2 
where e2.Salary > e.Salary and e2.DepartmentId = e.DepartmentId)
order by e.DepartmentId, e.Salary desc