package com.project.yuliya.canyouescape.server.service;


import com.project.yuliya.canyouescape.server.entity.User;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface UserService {

    List<User> getTopRate(Sort sort);
    Long saveUser(User user);
    Integer saveTime(User user);

}
