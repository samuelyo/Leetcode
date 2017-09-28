select a.Department as Department,b.Name as Employee,a.Salary from
(select e.DepartmentId as DepartmentId , d.Name as Department, max(e.Salary) as Salary from Employee as e join Department as d on e.DepartmentId = d.Id group by d.Name) as a join
Employee as b on a.Salary = b.Salary where a.DepartmentId = b.DepartmentId