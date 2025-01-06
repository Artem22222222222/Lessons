package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserRepository {
    private List<User> usersList = new ArrayList<>();
    public Optional<User> findUserById(int id){
        return usersList.stream().filter(x-> Objects.equals(x.getId(), id)).findFirst();
    }
    public Optional<User> findUserByEmail(String email){
        return usersList.stream().filter(x-> Objects.equals(x.getEmail(), email)).findFirst();
    }
    public Optional<List<User>> findAllUsers(){
        return Optional.ofNullable(usersList);
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }
}
