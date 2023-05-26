package Interface;

import domain.User;

public interface UserService {
    User cheakPassword(String login, String password);
    User register (String login, String password, String name, String surname);
    void  changePassword (String login, String OldPassword, String NewPassword, User user);
    void changeLogin (String login, String password, String NewLogin,User user);
}
