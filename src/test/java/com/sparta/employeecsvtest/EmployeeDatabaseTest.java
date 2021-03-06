package com.sparta.employeecsvtest;

import com.sparta.employeecsv.database.ConnectionFactory;
import com.sparta.employeecsv.model.Employee;
import com.sparta.employeecsv.model.EmployeeDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
public class EmployeeDatabaseTest {
    private static EmployeeDatabase employee;

    public EmployeeDatabaseTest() throws SQLException, IOException {
    }

    @BeforeAll

    public static void setUp() {
        employee = new EmployeeDatabase();
    }

    private Connection connection = ConnectionFactory.getConnection();

    String dropTable = "DROP TABLE IF EXISTS `EmployeeRecords`;"; //drop table if exists

    String createTable = "CREATE TABLE `EmployeeRecords` (" +
            "`EmployeeID` INT," +
            "`NamePrefix` VARCHAR(5)," +
            "`FirstName` VARCHAR(30)," +
            "`MiddleInitial` CHAR(1)," +
            "`LastName` VARCHAR(30)," +
            "`Gender` CHAR(1)," +
            "`Email` VARCHAR(50)," +
            "`DateOfBirth` DATE," +
            "`DateOfJoining` DATE," +
            "`Salary` DECIMAL(12,2)," +
            "PRIMARY KEY (`EmployeeID`)" +
            ");";

    @Test
    @DisplayName("Given a set of records to insert into the database, return true if the records are retrieved after insertion")
    public void GivenRecordsInsertedIntoDatabase_recordsCanBeRetrieved() throws SQLException, ParseException {
        boolean exists = false;
        ArrayList<Employee> testRecords = new ArrayList<>();
        Employee e = new Employee(1, "Mr", "Mihai", 'T', "Udrea", 'M', "udreamihai@gmail.com", null, null, 75000F);
        testRecords.add(e);
        System.out.println(testRecords);
        Statement st = connection.createStatement(); //prepare java statement
        st.executeUpdate(dropTable); //execute the query
        st.executeUpdate(createTable);

        employee.insertRecordsList(testRecords);//insert records

        ResultSet rs = st.executeQuery("SELECT * FROM `EmployeeRecords`;");
        while (rs.next()) {
            int id = rs.getInt("EmployeeID");
            String fName = rs.getString("FirstName");
            String lName = rs.getString("LastName");
            if (id == 1 && fName.equals("Mihai") && lName.equals("Udrea")) exists = true;
        }
        st.close(); //close connection to database
        Assertions.assertTrue(exists);
    }

    @Test
    @DisplayName("Retrieve Employee Records")
    public void checkGetAllEmployeesFromDB() {
        EmployeeDatabase employeeDatabase = new EmployeeDatabase();
        List<Employee> employees = employeeDatabase.getEmployees();
        for(Employee emp : employees) {
            System.out.println(emp.toString());
        }
        Assertions.assertNotNull(employees);
    }

}
