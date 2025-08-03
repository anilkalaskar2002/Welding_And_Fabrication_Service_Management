package com.example.CrudOperation.Service;

import com.example.CrudOperation.Model.User;
import com.example.CrudOperation.Repostaries.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public UserService(UserRepo userrepo) {
        this.userrepo = userrepo;
    }

    @Autowired
    private UserRepo userrepo;

    public List<User> getAllUsers() {
        return userrepo.findAll();
    }

    public void deleteUser(Long id) {
         userrepo.deleteById(id);
    }

    public void addUser(User user) {
        userrepo.save(user);
    }

    public void updateUser(User user) {
         userrepo.save(user);
    }
}
