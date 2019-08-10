package tool.service;

import tool.dao.UserDao;
import tool.dao.UserDaoImpl;
import tool.model.User;

public class UserService {

    private UserDao userDao = new UserDaoImpl();

    boolean checkIfValid (String login, String password) {
        User user = userDao.getUser(login);

        return user.getLogin().equals(login) && user.getPassword().equals(password);
    }
}