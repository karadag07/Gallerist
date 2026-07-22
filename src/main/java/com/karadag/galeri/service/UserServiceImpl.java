package com.karadag.galeri.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.karadag.galeri.dto.RequestUser;
import com.karadag.galeri.entity.User;
import com.karadag.galeri.repository.UserRepository;
import com.karadag.galeri.service.IService.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Override
    public String saveUser(RequestUser request) {
        User user = new User();
        BeanUtils.copyProperties(request, user);
        userRepository.save(user);
        return "Hesap basarili bir sekilde olusturulmustur" + user.getUsername();
    }

}
