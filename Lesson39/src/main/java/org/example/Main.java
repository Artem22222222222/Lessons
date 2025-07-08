package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        CustomerDao customerDao = context.getBean(CustomerDao.class);
        Long id = customerDao.addCustomer(new Customer(10L, "A", "B", "C")).get().getId();
        customerDao.findCustomerById(id);
        customerDao.getAllCustomers();
    }
}