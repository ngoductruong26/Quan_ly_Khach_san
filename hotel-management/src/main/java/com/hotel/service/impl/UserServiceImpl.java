package com.hotel.service.impl;

import com.hotel.entity.User;
import com.hotel.repository.UserRepository;
import com.hotel.service.UserService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }


    @Override
    public User getById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy user"));
    }


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }


    @Override
    public User update(Long id, User user) {

        User oldUser = getById(id);

        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setFullName(user.getFullName());
        oldUser.setRole(user.getRole());

        return userRepository.save(oldUser);
    }


    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}