package it.aliut.hmfrontend.service;

import it.aliut.hmfrontend.entity.User;

public interface IUserService {
    User[] getAll();

    User getById(String id);
}
