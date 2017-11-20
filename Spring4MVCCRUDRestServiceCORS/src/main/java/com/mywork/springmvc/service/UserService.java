package com.mywork.springmvc.service;

/**
 * @author ManiKanta Kandagatla
 */
import java.util.List;

import com.mywork.springmvc.model.User;

public interface UserService
{

    Boolean saveUser(User user);

    Boolean updateUser(long id, User user);

    Boolean deleteUser(long id);

    List<User> getAllUsers();

    User getUser(long id);
}
