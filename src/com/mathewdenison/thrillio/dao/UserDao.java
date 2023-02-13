package com.mathewdenison.thrillio.dao;

import com.mathewdenison.thrillio.DataStore;
import com.mathewdenison.thrillio.entities.User;

/**
 * Dao class to retrieve users stored in database.
 */
public class UserDao {
  public User[] getUsers() {
    return DataStore.getUsers();
  }
}
