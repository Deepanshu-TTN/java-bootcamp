package com.ttn.jpa.repository;

import com.ttn.jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /*Display the first name, last name of all employees having
    salary greater than average salary ordered in ascending by their age
    and in descending by their salary.*/
    @Query("SELECT firstName, lastName FROM Employee " +
            "WHERE salary > (select AVG(salary) from Employee) " +
            "ORDER BY age ASC, salary DESC")
    public List<Object[]> findEmployeesMoreThanAvgSalarySorted();

    /*Update salary of all employees by a salary passed as a parameter
    whose existing salary is less than the average salary. */
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Employee " +
            "SET salary=:salary " +
            "WHERE salary<:avgSalary")
    public void incrementEmployeeSalary(@Param("salary") double salary, @Param("avgSalary") double avgSalary);

    @Query("SELECT AVG(salary) FROM Employee")
    public Double getEmployeeAvgSalary();

    /*Delete all employees with minimum salary.*/
    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM Employee WHERE salary = :minSalary")
    public void deleteEmployeeWithMinSalary(@Param("minSalary") double minSalary);

    @Query("SELECT MIN(salary) FROM Employee")
    public Double getEmployeeMinSalary();

    @Query(value = "SELECT empId, empFirstName, empAge FROM " +
            "employeeTable where empLastName LIKE %:lname", nativeQuery = true)
    public List<Object[]> getEmployeeWithLastName(@Param("lname") String lname);

    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM employeeTable WHERE empAge > :age", nativeQuery = true)
    public void purgeOldEmployees(@Param("age") int age);
}