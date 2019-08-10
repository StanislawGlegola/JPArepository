package tool.dao;

import tool.model.User;

public interface UserDao {
    User getUser(String login);
}