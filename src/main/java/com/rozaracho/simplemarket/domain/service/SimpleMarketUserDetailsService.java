package com.rozaracho.simplemarket.domain.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SimpleMarketUserDetailsService implements UserDetailsService {
    private static List<User> users = new ArrayList();

    public SimpleMarketUserDetailsService() {
        users.add(new User("rosali", "{noop}prueba", new ArrayList<>()));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = users.stream().filter(u -> u.getUsername().equals(username)).findAny();

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not found by name: " + username);
        }

        return user.get();
    }
}