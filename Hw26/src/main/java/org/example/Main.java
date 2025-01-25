package org.example;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("street", "city", "state");
        User user = new User("Dima", 20);
        user.setAddress(address);
        System.out.println(user);

    }
}