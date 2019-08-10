package tool.dao;

import tool.model.User;

public class UserDaoImpl implements UserDao {

    @Override
    public User getUser(String login) {
        return new User("login", "pwd");
    }
}