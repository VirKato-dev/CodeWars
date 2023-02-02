package stepik.mts.bank.middle.m5.repository;

import stepik.mts.bank.middle.m5.model.User;

import java.util.List;
import java.util.NoSuchElementException;


public class UserRepositoryImpl implements UserRepository {
    private final List<User> users;

    public UserRepositoryImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public synchronized List<User> findAll() {
        return users;
    }

    @Override
    public synchronized User findByMsisdn(long msisdn) throws NoSuchElementException {
        return users.stream().filter(u -> u.getMsisdn() == msisdn).limit(1)
                .findFirst().orElseThrow();
    }
}
