package com.project.yuliya.canyouescape.server.controller;

import com.project.yuliya.canyouescape.server.entity.User;
import com.project.yuliya.canyouescape.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/getTopRateUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getTopRateUsers() {
        return service.getTopRate(new Sort("time"));
    }


    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ResponseBody
    public User saveUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @RequestMapping(value = "/saveUserTime", method = RequestMethod.POST)
    @ResponseBody
    public Integer saveUserTime(@RequestBody User user)
    {
        Integer i =(Integer)service.saveTime(user);
        return i;
    }


}
