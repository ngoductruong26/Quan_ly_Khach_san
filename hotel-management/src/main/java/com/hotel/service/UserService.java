package com.hotel.service;

import com.hotel.entity.User;
import java.util.List;

public interface UserService {

    User login(String username, String password);

    List<User> getAll();

    User getById(Long id);

    User save(User user);

    User update(Long id, User user);

    void delete(Long id);
}