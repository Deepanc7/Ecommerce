package com.auth.Service;

import com.auth.DTO.UsersResponse;
import com.auth.Entity.UserRegisterEntity;
import com.auth.Repository.UserRegisterEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserRegisterEntityService implements UserDetailsService {

    @Autowired
    private UserRegisterEntityRepository userRegisterEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserRegisterEntity> optionalUser = userRegisterEntityRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new UsernameNotFoundException("user not found");
        }

    }

    public UserDetails save(UserRegisterEntity user) {
        return userRegisterEntityRepository.saveUser(user);
    }

    public List<UsersResponse> getAllUsers() {
        List<UserRegisterEntity> users = userRegisterEntityRepository.findAll();
        return users.stream().map(user -> {
            UsersResponse dto = new UsersResponse();
            dto.setUsername(user.getUsername());
            dto.setRole(user.getRole());
            return dto;
        }).collect(Collectors.toList());
    }
}
