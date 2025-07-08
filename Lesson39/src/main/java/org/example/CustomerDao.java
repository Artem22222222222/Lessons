package org.example;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDao {
    private final JdbcTemplate jdbcTemplate;
    private final CustomerRowMapper customerRowMapper;

    public CustomerDao(JdbcTemplate jdbcTemplate, CustomerRowMapper customerRowMapper) {
        this.customerRowMapper = customerRowMapper;
        this.jdbcTemplate = jdbcTemplate;
        jdbcTemplate.update(conn -> {
            PreparedStatement statement = conn.prepareStatement("CREATE TABLE IF NOT EXISTS shop.Customer (" +
                    "    id INT AUTO_INCREMENT PRIMARY KEY," +
                    "    fullName VARCHAR(255)," +
                    "    email VARCHAR(255)," +
                    "    socialSecurityNumber VARCHAR(255)" +
                    ");");
            return statement;
        });

    }

    public Optional<Customer> addCustomer(Customer customer){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(conn -> {
            PreparedStatement statement = conn.prepareStatement("insert into shop.Customer (fullName, email, socialSecurityNumber) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, customer.getFullname());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getSocialSecurityNumber());
            return statement;
        }, keyHolder);
        if (rowsAffected == 0){
            return Optional.empty();
        }
        Number newId = keyHolder.getKey();
        customer.setId(newId.longValue());
        return Optional.of(customer);
    }
    public Customer deleteCustomer(Customer customer){
        return customer;
    }
    public void updateCustomer(Customer customer){

    }
    public Optional<Customer> findCustomerById(long id){
        Customer customer = jdbcTemplate.queryForObject("SELECT * FROM shop.Customer where id = ?",
                customerRowMapper, id);
        return Optional.ofNullable(customer);
    }
    public Optional<List<Customer>> getAllCustomers(){
        List<Customer> customers = jdbcTemplate.query("SELECT * FROM shop.Customer", customerRowMapper);
        return Optional.of(customers);
    }
}
