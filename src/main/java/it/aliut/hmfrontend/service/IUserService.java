package it.aliut.hmfrontend.service;

import it.aliut.hmfrontend.data.RegisterUserData;
import it.aliut.hmfrontend.entity.User;

public interface IUserService {
    User[] getAll();

    User register(RegisterUserData data);
}
