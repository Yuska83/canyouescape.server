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

    //сохранение нового игрока
    public Long saveUser(User user) {
        //с помощь JpaRepository сделать это можно стандартым методом CRUD
        User u = repository.save(user);
        return u.getGlobalId();
    }

    //сохранение времени игрока
    public Integer saveTime(User user) {

        //если это уже зарегистрированный игрок, заменится только поле time
        repository.saveAndFlush(user);

        List<User> topRateUsers = SortUsers(new Sort("time"));
        long idUser = user.getGlobalId();

        //место игрока в общем рейтинге
        Integer rate = -1 ;
        for (int i = 0; i < topRateUsers.size() ; i++) {

            if(topRateUsers.get(i).getGlobalId() == idUser)
            {
                rate = Integer.valueOf(i+1);break;
            }
        }
        return rate;
    }

    //возврат 5 лучших игроков
    public List<User> getTopRate(Sort sort) {
        List<User> topRateUsers=SortUsers(sort);
        if(topRateUsers.size()<5) return topRateUsers;
        return topRateUsers.subList(0,5);
    }

    //формирование рейтинга среди игроков
    public List<User> SortUsers(Sort sort)
    {
        //Sort определяет по какому полю будет идти сортировка
        return repository.findAll(sort);
    }
}
