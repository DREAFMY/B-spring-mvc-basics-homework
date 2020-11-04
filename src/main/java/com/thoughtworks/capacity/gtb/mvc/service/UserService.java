package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    List<User> users = new ArrayList<>();

    public void register(User user) {
        if (users.stream().anyMatch(e -> e.getUserName().equals(user.getUserName()))) {
            //todo throw exception
        }
        users.add(user);
    }

    public User login(String userName, String password) {
        List<User> user1 = users.stream().filter(u -> u.getUserName().equals(userName) && u.getPassword().equals(password))
                .collect(Collectors.toList());
        if (user1.size() != 1) {
            //todo throw exception
        }
        return user1.get(0);
    }
}
