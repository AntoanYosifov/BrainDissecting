package com.antdevrealm.BrainDissecting.service.impl;

import com.antdevrealm.BrainDissecting.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class BDissectingUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public BDissectingUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
