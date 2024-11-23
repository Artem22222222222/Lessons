package org.example;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws UserNotFoundException, UserListNotFoundException {
        UserRepository userRepository = new UserRepository();
        userRepository.getUsersList().add(new User(1, "a", "a1"));
        userRepository.getUsersList().add(new User(2, "b", "b2"));
        userRepository.getUsersList().add(new User(3, "c", "c3"));
        userRepository.getUsersList().add(new User(4, "d", "d4"));

        Optional<User> testUser = userRepository.findUserById(2);
        if (testUser.isPresent()){
            System.out.println(testUser);
        }else {
            throw new UserNotFoundException();
        }

        Optional<User> testUser2 = userRepository.findUserByEmail("a1");
        if (testUser2.isPresent()){
            System.out.println(testUser2);
        }else {
            throw new UserNotFoundException();
        }

        //код для перевірки як добре все ламається)
//        userRepository.setUsersList(null);

        Optional<List<User>> testUser3 = userRepository.findAllUsers();
        if (testUser3.isPresent()){
            System.out.println(testUser3);
        }else {
            throw new UserListNotFoundException();
        }
    }
}