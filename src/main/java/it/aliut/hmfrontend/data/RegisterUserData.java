package it.aliut.hmfrontend.data;

/**
 * Encapsulates data for registering a new user to the {@link it.aliut.hmfrontend.service.UserService}
 */
public class RegisterUserData {

    public RegisterUserData(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    private String name;
    private String email;
}
