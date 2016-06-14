package com.project.yuliya.canyouescape.server.service;


import com.project.yuliya.canyouescape.server.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    User getByID(long id);
    User save(User user);
    void remove(long id);
}
