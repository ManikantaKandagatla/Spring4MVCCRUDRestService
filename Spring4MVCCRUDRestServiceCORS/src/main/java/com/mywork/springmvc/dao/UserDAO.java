package com.mywork.springmvc.dao;
/**
 * @author ManiKanta Kandagatla
 */
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mywork.springmvc.model.User;


@Repository
@Transactional
public class UserDAO
{

    @Autowired
    private SessionFactory sessionFactory;

    public UserDAO()
    {
        // TODO Auto-generated constructor stub
    }

    public Boolean saveUser(User user)
    {
        Session session = sessionFactory.getCurrentSession();
        Boolean result = false;
        try
        {
            session.persist(user);
            result = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    public List<User> getUser()
    {
        System.out.println("Retrieving all Users..!!");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        List<User> users = null;
        try
        {
            users = (List<User>) criteria.list();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return users;
    }

    public User getUser(long id)
    {
        System.out.println("Retrieving user with id:" + id);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        User user = null;
        try
        {
            criteria.add(Restrictions.eq("id", id));
            user = (User) criteria.uniqueResult();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return user;
    }

    public Boolean deleteUser(long id)
    {
        Boolean result = false;
        try
        {
            Query query = sessionFactory.getCurrentSession()
                    .createSQLQuery("delete from user where id = :id");
            query.setLong("id", id);
            query.executeUpdate();
            result = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    public Boolean updateUser(long id, User user)
    {
        Boolean result = false;
        try
        {
            Query query = sessionFactory.getCurrentSession().createQuery(
                    "update User set name = :name, age = :age, salary = :salary where id = :id");
            query.setParameter("name", user.getName());
            query.setParameter("age", user.getAge());
            query.setParameter("salary", user.getSalary());
            query.setParameter("id", id);
            int rows = query.executeUpdate();
            result = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

}
