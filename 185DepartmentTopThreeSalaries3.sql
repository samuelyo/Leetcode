SELECT
    d.Name Department, e.Name Employee, e.Salary Salary
FROM
    (
        SELECT DepartmentId, Name, Salary 
        FROM Employee 
        WHERE 3 > (
            SELECT COUNT(e1.Salary)
            FROM (
                SELECT DISTINCT Salary, DepartmentId 
                FROM Employee 
            ) e1
            WHERE
                Employee.DepartmentId = e1.DepartmentId 
            AND
                Employee.Salary < e1.Salary
        )
        ORDER BY DepartmentId ASC, Salary DESC
    ) e 
LEFT JOIN
    Department d
ON 
    e.DepartmentId = d.Id
WHERE
    d.Name IS NOT NULL