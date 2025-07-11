package com.DAO.User;

import com.Model.User;

public interface UserDAO {
    boolean registerUser(User user);
    User getUserByUsernameAndPassword(String username, String password);
}

