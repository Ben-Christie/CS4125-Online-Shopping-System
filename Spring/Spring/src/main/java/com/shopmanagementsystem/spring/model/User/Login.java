package com.shopmanagementsystem.spring.model.User;

import com.shopmanagementsystem.spring.Database.DAO.UserDAO;
import com.shopmanagementsystem.spring.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/*
Login service class, connects to db and verifies creds
 */
@Service
public class Login {

    @Autowired
    UserDAO userDAO;

    public boolean verifyCreds(User user){
        List<User> users = userDAO.getAllUsers();
        for(User u : users){
            if(user.getName().equalsIgnoreCase(u.getName())){
                //Email is here so now we check password
                if(u.getPassword().equals(user.getPassword())){
                    return true;
                }
            }
        }
        return false;
    }


}
