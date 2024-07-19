package com.antdevrealm.BrainDissecting.service.impl;

import com.antdevrealm.BrainDissecting.model.dto.user.UserRegistrationDTO;
import com.antdevrealm.BrainDissecting.model.entity.Role;
import com.antdevrealm.BrainDissecting.model.entity.User;
import com.antdevrealm.BrainDissecting.repository.RoleRepository;
import com.antdevrealm.BrainDissecting.repository.UserRepository;
import com.antdevrealm.BrainDissecting.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        this.userRepository.save(map(userRegistrationDTO));
    }

    private User map(UserRegistrationDTO userRegistrationDTO){
        User user = this.modelMapper.map(userRegistrationDTO, User.class);

        user.setPassword(this.passwordEncoder.encode(userRegistrationDTO.getPassword()));
        Role role = new Role();
        role.setName("user");
        roleRepository.save(role);
        user.setRole(role);

        return user;
    }
}
