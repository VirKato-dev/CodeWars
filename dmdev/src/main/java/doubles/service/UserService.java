package doubles.service;

import doubles.dao.UserDao;
import doubles.model.User;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;
    private final List<User> users = new ArrayList<>();

    public List<User> getAll() {
        return users;
    }

    public void add(User... users) {
        this.users.addAll(Arrays.asList(users));
    }

    public boolean delete(Integer userId) {
        return userDao.delete(userId);
    }
}
