package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDAO {
    private DatabaseConnector databaseConnector;

    public EmployeeDAO() throws SQLException, ClassNotFoundException, ConnectionException {
        databaseConnector = new DatabaseConnector();

        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("create table if not exists t_employee (" +
                    "id int auto_increment PRIMARY KEY, " +
                    "name varchar(100), " +
                    "age int, " +
                    "salary int);");
            boolean success = statement.execute();
//            if (!success){
//                throw new ConnectionException("Can`t connect to data base");
//            }
        }
    }

    public void addEmployee(Employee employee) throws SQLException {
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("insert into " +
                    "t_employee(name, age, salary) " +
                    "values(?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getAge());
            statement.setInt(3, employee.getSalary());
            statement.execute();
            ResultSet results = statement.getGeneratedKeys();
            if (results.next()) {
                employee.setId(results.getInt(1));
            }
        }
    }

    public Optional<List<Employee>> search(int id) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from t_employee as e where e.id = ?;");
            statement.setInt(1, id);
            statement.execute();
            try (ResultSet results = statement.getResultSet()) {
                while (results.next()) {
                    employees.add(new Employee(
                            results.getString("name"),
                            results.getInt("age"),
                            results.getInt("salary")));
                }
            }
            return Optional.of(employees);
        }
    }

    public void update(Employee employee, int id) throws SQLException {
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update t_employee as e \n" +
                    "set e.name = ?, e.age = ?, e.salary = ? \n" +
                    "where e.id = ?" +
                    ";");
            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getAge());
            statement.setInt(3, employee.getSalary());
            statement.setInt(4, id);

            statement.execute();
        }
    }

    public void delete(int id) throws SQLException {
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("delete from t_employee as e where e.id = ?;");
            statement.setInt(1, id);
            statement.execute();
        }
    }
}
