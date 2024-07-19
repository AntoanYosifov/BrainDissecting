package com.antdevrealm.BrainDissecting.service;

import com.antdevrealm.BrainDissecting.model.dto.user.UserRegistrationDTO;

public interface UserService {
    void registerUser(UserRegistrationDTO userRegistrationDTO);
}
