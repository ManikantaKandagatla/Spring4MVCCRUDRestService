package com.mywork.springmvc.model;

/**
 * @author  ManiKanta Kandagatla
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User
{
    
    @Column
    private String email;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private double salary;
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public User()
    {
        email = null;
    }

    public User(String id, String name, int age, double salary)
    {
        this.email = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }
    
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    @Override
    public String toString()
    {
        return "User [id=" + email + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
    }

}
