package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, ConnectionException {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.addEmployee(new Employee("Allan", 34, 50000));
        employeeDAO.search(1);
        employeeDAO.update(new Employee("super", 25, 236148), 1);
        employeeDAO.delete(1);
    }
}