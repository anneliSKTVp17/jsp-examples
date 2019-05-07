/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repositories;

import com.mycompany.fake.FakeStorage;
import com.mycompany.models.User;
import java.util.List;

/**
 *
 * @author user
 */
public class UserRepositoryInMemoryImpl implements UserRepository{

    @Override
    public List<User> findAll() {
    return FakeStorage.storage().users();
    }

    @Override
    public void save(User user) {
    FakeStorage.storage().users().add(user);
    }

    @Override
    public boolean isExist(String name, String password) {
    for (User user : FakeStorage.storage().users()) {
        if (user.getName().equals(name) &&
                user.getPassword().equals(password)) {
            return true;
        }
    }    
    return false;
    }
}

