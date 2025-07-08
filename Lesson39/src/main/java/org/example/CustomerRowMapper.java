package org.example;


import org.jspecify.annotations.Nullable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class CustomerRowMapper implements RowMapper<Customer> {
    @Override
    public @Nullable Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();

        customer.setId(rs.getLong(1));
        customer.setFullname(rs.getString(2));
        customer.setEmail(rs.getString(3));
        customer.setSocialSecurityNumber(rs.getString(4));

        return customer;
    }
}
