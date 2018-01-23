 select c.Name as Department, b.Name as Employee, b.Salary as Salary
 from
 (select DepartmentId, max(Salary) as highest
 from Employee
 group by DepartmentId) as a,
 Employee as b, Department as c
 where a.DepartmentId = c.Id and a.highest = b.Salary and a.DepartmentId = b.DepartmentId