package com.project.yuliya.canyouescape.server.controller;

import com.project.yuliya.canyouescape.server.entity.User;
import com.project.yuliya.canyouescape.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllReminders() {
        return service.getTopRate();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getReminder(@PathVariable("id") long remindID) {
        return service.getByID(remindID);
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ResponseBody
    public User saveUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @RequestMapping(value = "/saveUserTime", method = RequestMethod.POST)
    @ResponseBody
    public  void saveUserTime(@RequestBody long id,@RequestBody long time) {
         service.saveTime(id,time);
    }


}
