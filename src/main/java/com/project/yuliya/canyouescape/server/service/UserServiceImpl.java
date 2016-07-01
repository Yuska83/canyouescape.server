package com.project.yuliya.canyouescape.server.service;

import com.project.yuliya.canyouescape.server.entity.User;
import com.project.yuliya.canyouescape.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public User saveTime(User user) {
       return repository.saveAndFlush(user);
    }

    public List<User> getTopRate(Sort sort) {
        List<User> allUsers =  repository.findAll(sort);
        List<User> topRateUsers = allUsers.subList(0,5);
        return topRateUsers;
    }

    public User getByID(long id) {
        return repository.findOne(id);
    }




}
