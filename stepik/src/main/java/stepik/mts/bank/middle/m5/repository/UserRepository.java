package stepik.mts.bank.middle.m5.repository;

import stepik.mts.bank.middle.m5.model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findByMsisdn(long msisdn);
}
