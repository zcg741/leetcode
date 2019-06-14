/*Employee 表包含所有员工信息，每个员工有其对应的 Id, salary 和 department Id。

 +----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
+----+-------+--------+--------------+

 Department 表包含公司所有部门的信息。 

 +----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+

 编写一个 SQL 查询，找出每个部门工资最高的员工。例如，根据上述给定的表格，Max 在 IT 部门有最高工资，Henry 在 Sales 部门有最高工资。 

 +------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| Sales      | Henry    | 80000  |
+------------+----------+--------+
{"headers": {"Employee":
 ["Id", "Name", "Salary", "DepartmentId"], "Department": ["Id", "Name"]}, "rows": {
 "Employee": [[1, "Joe", 70000, 1], [2, "Jim", 90000, 1], [3, "Henry", 80000, 2],
 [4, "Sam", 60000, 2], [5, "Max", 90000, 1]],
 "Department": [[1, "IT"], [2, "Sales"]]}}
*/

select d.Name as Department,e.Name as Employee, e.Salary from
(select max(Salary) as Salary,DepartmentId from Employee
group by DepartmentId) t
join Employee e on e.Salary = t.Salary and e.DepartmentId = t.DepartmentId
join Department d on d.Id = e.DepartmentId;

SELECT maxDTb.Name AS Department,c.Name AS Employee, c.Salary
FROM (
	SELECT b.Id, b.Name, MAX(a.Salary) AS Salary
	FROM Employee a
		INNER JOIN Department b ON a.DepartmentId = b.Id
	GROUP BY b.Id, b.Name
) maxDTb
	INNER JOIN Employee c
	ON maxDTb.Id = c.DepartmentId
		AND maxDTb.Salary = c.Salary;



