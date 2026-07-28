package com.hotel.mapper;

import com.hotel.dto.UserDTO;
import com.hotel.entity.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {

        if (user == null) {
            return null;
        }

        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .fullName(user.getFullName())
                .role(user.getRole())
                .build();
    }

    public static User toEntity(UserDTO dto) {

        if (dto == null) {
            return null;
        }

        User user = new User();

        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setFullName(dto.getFullName());
        user.setRole(dto.getRole());

        // Không set password ở đây
        // Password sẽ được xử lý khi tạo mới hoặc cập nhật tài khoản

        return user;
    }
}