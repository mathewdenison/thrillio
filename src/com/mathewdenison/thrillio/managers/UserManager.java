package com.mathewdenison.thrillio.managers;

import com.mathewdenison.thrillio.dao.UserDao;
import com.mathewdenison.thrillio.entities.User;

/**
 * Class to enable methods of UserManager such as creation of users and pulling data from storage.
 */
public class UserManager {
  private static final UserManager instance = new UserManager();
  private static final UserDao dao = new UserDao();

  private UserManager() {
  }

  public static UserManager getInstance() {
    return instance;
  }

  /**
   * Method used to create a user object from the passed values.
   *
   * @param id The unique internally stored ID of the user
   * @param email The user's email
   * @param password The user's password
   * @param firstName The user's first name
   * @param lastName The user's last name
   * @param gender The user's gender taken from the Gender class
   * @param userType The user's type (User, Editor, or Chief Editor)
   * @return The created user object
   */
  public User createUser(long id, String email, String password, String firstName, String lastName,
                         int gender, String userType) {
    User user = new User();
    user.setId(id);
    user.setEmail(email);
    user.setPassword(password);
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setGender(gender);
    user.setUserType(userType);

    return user;
  }

  public User[] getUsers() {
    return dao.getUsers();
  }
}
