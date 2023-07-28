package jm.service;

import jm.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save(User user);

    void update(User user);

    void deleteById(long id);

    User findById(long id);

    List<User> findAll();

    User findByUsername(String username);

}
