package it.aliut.hmfrontend.repository;

import it.aliut.hmfrontend.entity.User;

public interface IUserRepository extends IRepository<String, User> {
    User add(User user);
}