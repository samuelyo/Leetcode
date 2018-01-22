CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      select a.salary
      from (select distinct salary from Employee) as a
      where N - 1 = (select count(*) from (select distinct salary from Employee) as b where b.salary > a.salary)
  );
END