package it.aliut.hmfrontend.service;

import it.aliut.hmfrontend.data.RegisterUserData;
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

    /**
     * Returns all registered users.
     *
     * @return An array of {@link User} objects.
     */
    @Override
    public User[] getAll() {
        return userRepository.getAll();
    }

    /**
     * Registers a new user.
     */
    @Override
    public User register(RegisterUserData data) {
        if (data == null) throw new NullPointerException("data is null");

        User user = new User();
        user.setName(data.getName());
        user.setEmail(data.getEmail());

        return userRepository.add(user);
    }
}
