package tool.service;

import tool.dao.UserDao;
import tool.dao.UserDaoImpl;
import tool.model.User;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    public boolean checkIfValid(String login, String password) {
        User user = userDao.getUser(login);

        return user != null
                && user.getLogin().equals(login)
                && user.getPassword().equals(password);
    }
}