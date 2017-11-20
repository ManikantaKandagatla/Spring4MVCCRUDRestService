package com.mywork.springmvc.service;

/**
 * @author ManiKanta Kandagatla
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mywork.springmvc.dao.UserDAO;
import com.mywork.springmvc.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserDAO userDAO;

    public List<User> getAllUsers()
    {
        return userDAO.getUser();
    }

    public User getUser(long id)
    {
        return userDAO.getUser(id);
    }

    public Boolean saveUser(User user)
    {

        return userDAO.saveUser(user);
    }

    public Boolean updateUser(long id,User user)
    {
        return userDAO.updateUser(id,user);
    }

    public Boolean deleteUser(long id)
    {
        return userDAO.deleteUser(id);
    }

}
