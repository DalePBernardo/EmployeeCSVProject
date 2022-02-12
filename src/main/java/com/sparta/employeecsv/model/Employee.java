package com.sparta.employeecsv.model;

import java.sql.Date;
import java.util.Objects;

public class Employee {

    private Integer employeeID;

    private String namePrefix;
    private String firstName;
    private Character middleInitial;
    private String lastName;

    private Character gender;
    private String email;
    private Date dateOfBirth;
    private Date dateOfJoin;

    private Float salary;

    public Employee(Integer employeeID, String namePrefix, String firstName,
                    Character middleInitial, String lastName, Character gender,
                    String email, Date dateOfBirth, Date dateOfJoin,
                    Float salary
    ) {

        this.employeeID = employeeID;

        this.namePrefix = namePrefix;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;

        this.dateOfBirth = dateOfBirth;
        this.dateOfJoin = dateOfJoin;

        this.gender = gender;
        this.email = email;
        this.salary = salary;

    }

    public Employee() {
        super();
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public Character getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public Character getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getDateOfJoin() {
        return dateOfJoin;
    }

    public Float getSalary() {
        return salary;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleInitial(Character middleInitial) {
        this.middleInitial = middleInitial;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfJoin(Date dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public boolean isRecordValid() {

        if (employeeID == null || namePrefix == null || firstName == null ||
                middleInitial == null || lastName == null || gender == null ||
                email == null || dateOfBirth == null || dateOfJoin == null ||
                salary == null) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "(employeeID: " + employeeID +
                " | namePrefix: " + namePrefix +
                " | firstName: " + firstName +
                " | middleInitial: " + middleInitial +
                " | lastName: " + lastName +
                " | gender: " + gender +
                " | email: " + email +
                " | dob: " + dateOfBirth +
                " | doj: " + dateOfJoin +
                " | salary: " + salary + ")\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeID.equals(employee.employeeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID);
    }
}
