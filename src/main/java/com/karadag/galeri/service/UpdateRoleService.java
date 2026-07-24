package com.karadag.galeri.service;

import org.springframework.stereotype.Service;

import com.karadag.galeri.dto.ResponseUser;
import com.karadag.galeri.dto.UpdateRoleRequest;
import com.karadag.galeri.entity.User;
import com.karadag.galeri.enums.MessageType;
import com.karadag.galeri.exception.BaseException;
import com.karadag.galeri.exception.ErrorDetails;
import com.karadag.galeri.mapper.UserMapper;
import com.karadag.galeri.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateRoleService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public ResponseUser updateRole(Long id, UpdateRoleRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(
                        () -> new BaseException(new ErrorDetails(MessageType.NO_RECORD_EXIST, "kullanici bulunamadi")));

        user.setRole(request.getRole());

        return userMapper.toResponse(userRepository.save(user));
    }
}
