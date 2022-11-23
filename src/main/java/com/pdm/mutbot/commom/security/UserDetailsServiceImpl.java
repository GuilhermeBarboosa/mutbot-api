package com.pdm.mutbot.commom.security;

import com.pdm.mutbot.models.User;
import com.pdm.mutbot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException("User Not Found username: " + userName));

        List<String> profiles = new ArrayList<>();
        profiles.add("teste");

        return UserDetailsImpl.build(user, profiles);
    }

}
