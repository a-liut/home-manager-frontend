package it.aliut.hmfrontend.command;

/**
 * Encapsulates form data for registering a new user.
 */
public class RegisterUserCommand {

    public RegisterUserCommand(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }

    private String userName;

    private String userEmail;

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
