package com.project.yuliya.canyouescape.server.service;

import com.project.yuliya.canyouescape.server.entity.User;
import com.project.yuliya.canyouescape.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public Integer saveTime(User user) {
        repository.saveAndFlush(user);

        List<User> allUsers =  repository.findAll(new Sort("time"));
        long idUser = user.getId();
        Integer rate = -1 ;
        for (int i = 0; i < allUsers.size() ; i++) {

            if(allUsers.get(i).getId() == idUser)
            {
                rate = Integer.valueOf(i+1);break;
            }
        }
        return rate;
    }

    public List<User> getTopRate(Sort sort) {
        List<User> allUsers =  repository.findAll(sort);
        List<User> topRateUsers = allUsers.subList(0,5);
        return topRateUsers;
    }
}
