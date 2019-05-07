/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repositories;

import com.mycompany.models.User;
import java.util.List;

/**
 *
 * @author user
 */
public interface UserRepository {
    List<User> findAll();
    void save(User user);
    boolean isExist(String name, String password);
}
