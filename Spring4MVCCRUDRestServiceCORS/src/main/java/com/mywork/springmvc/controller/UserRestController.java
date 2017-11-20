package com.mywork.springmvc.controller;
/**
 * @author ManiKanta Kandagatla
 */
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mywork.springmvc.model.User;
import com.mywork.springmvc.service.UserService;
 
@RestController
public class UserRestController {
 
    @Autowired
    UserService userService;  
 
     
    /**
     * Retrieve All Users
     * @return List<Users>
     */
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.getAllUsers();
        System.out.println(users);
        if(users == null){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
 
 
    /**
     * Retrieve Single User
     * @param id
     * @return User
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with email " + id);
        User user = userService.getUser(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
 
     
    /**
     * Create a User
     * @param user
     * @param ucBuilder
     * @return 
     */
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getName());
        if (userService.saveUser(user)) {
            HttpHeaders headers = new HttpHeaders();
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        }
        
        else
        {
            System.out.println("A User with name " + user.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
    }
     
    /**
     * Update a User
     * @param id
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        System.out.println("Updating User " + id);
         
        if(userService.updateUser(id,user))
        {
            return new ResponseEntity<User>(user, HttpStatus.OK);   
        }
        else
        {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND); 
        }
    }
 
    /**
     * Delete a User
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with email " + id);
 
        if(userService.deleteUser(id))
        {
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }
        else
        {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }
}