/*
Employee 表包含所有员工信息，每个员工有其对应的 Id, salary 和 department Id 。 

 +----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
| 5  | Janet | 69000  | 1            |
| 6  | Randy | 85000  | 1            |
+----+-------+--------+--------------+
 

 Department 表包含公司所有部门的信息。 

 +----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+
 

 编写一个 SQL 查询，找出每个部门工资前三高的员工。例如，根据上述给定的表格，查询结果应返回： 

 +------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| IT         | Randy    | 85000  |
| IT         | Joe      | 70000  |
| Sales      | Henry    | 80000  |
| Sales      | Sam      | 60000  |
+------------+----------+--------+
 

*/

SELECT dep.Name Department, emp.Name Employee, emp.Salary
FROM (## 自定义变量RANK, 查找出 每个部门工资前三的排名
        SELECT te.DepartmentId, te.Salary,
               CASE
                    WHEN @pre = DepartmentId THEN @rank:= @rank + 1
                    WHEN @pre := DepartmentId THEN @rank:= 1
               END AS RANK
        FROM (SELECT @pre:=null, @rank:=0)tt,
             (## (部门,薪水)去重,根据 部门(升),薪水(降) 排序
                 SELECT DepartmentId,Salary
                 FROM Employee
                 GROUP BY DepartmentId,Salary
                 ORDER BY DepartmentId,Salary DESC
             )te
       )t
INNER JOIN Department dep ON t.DepartmentId = dep.Id
INNER JOIN Employee emp ON t.DepartmentId = emp.DepartmentId and t.Salary = emp.Salary and t.RANK <= 3
ORDER BY t.DepartmentId, t.Salary DESC ## t 结果集已有序,根据该集合排序




