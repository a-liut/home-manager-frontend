package it.aliut.hmfrontend.service;

import it.aliut.hmfrontend.entity.User;
import it.aliut.hmfrontend.repository.IUserRepository;
import org.springframework.stereotype.Service;

/**
 * Logic for managing {@link User} objects.
 */
@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User[] getAll() {
        return userRepository.getAll();
    }

    @Override
    public User getById(String id) {
        return userRepository.getById(id);
    }
}
