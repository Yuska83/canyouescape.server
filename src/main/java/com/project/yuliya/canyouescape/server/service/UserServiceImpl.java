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
    public List<User> getTopRate(Sort sort) {
        return repository.findAll(sort);
    }

    public User getByID(long id) {
        return repository.findOne(id);
    }

    public User saveUser(User user) {
        return repository.save(user);
    }

    public void saveTime(long id, long time) {
        ((User)repository.findOne(id)).setTime(time);
    }


}
