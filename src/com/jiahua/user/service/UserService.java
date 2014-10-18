package com.jiahua.user.service;

import com.jiahua.model.UserDAO;
import com.jiahua.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yu on 9/23/14.
 */

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public UserService() {}

    public List<User> getAllUser() throws Exception  {
        List<User> list = null;
        list = (List<User>)userDAO.findAll();
        return list;
    }

    public User getUser(int uid) throws Exception {
        User user = null;
        user = userDAO.findById(uid);
        return user;
    }

    public User getUser(String username, String password) throws Exception {
        User user = null;
        user = (User)userDAO.findByUsername(username).get(0);
        User tmp = (User)userDAO.findByPassword(password).get(0);

        if (user.getId().equals(tmp.getId())) {
        } else {
            // throw new Exception("登陆失败，不匹配");
            user = null;
        }
        return user;
    }

    public void insertUser(User user) throws Exception {
        userDAO.save(user);
    }

    public void updateUser(User user) throws Exception {
        userDAO.attachDirty(user);
    }
}
