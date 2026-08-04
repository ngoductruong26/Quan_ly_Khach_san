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
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Tên đăng nhập hoặc mật khẩu không chính xác"));
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Tên đăng nhập hoặc mật khẩu không chính xác");
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng"));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {

        User old = getById(id);

        old.setUsername(user.getUsername());
        old.setPassword(user.getPassword());
        old.setFullName(user.getFullName());
        old.setRole(user.getRole());

        return userRepository.save(old);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(getById(id));
    }
}