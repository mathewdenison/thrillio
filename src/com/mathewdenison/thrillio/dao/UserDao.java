package com.mathewdenison.thrillio.dao;

import com.mathewdenison.thrillio.DataStore;
import com.mathewdenison.thrillio.entities.User;

public class UserDao {
    public User[] getUsers() {
        return DataStore.getUsers();
    }
}
