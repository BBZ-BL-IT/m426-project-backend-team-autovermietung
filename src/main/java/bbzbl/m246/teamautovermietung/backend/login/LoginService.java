package bbzbl.m246.teamautovermietung.backend.login;

import org.springframework.stereotype.Service;

import bbzbl.m246.teamautovermietung.backend.user.UserModel;
import bbzbl.m246.teamautovermietung.backend.user.UserService;

@Service
public class LoginService {

    private final UserService userService;

    public LoginService(UserService userService) {
        this.userService = userService;
    }

    public String login(LoginUserDTO loginUser) {
        UserModel user = userService.getUserByUsername(loginUser.getUsername());

        if (user == null) {
            return "{ \"message\": \"User not found\" }";
        }

        if (!user.getPassword().equals(loginUser.getPassword())) {
            return "{ \"message\": \"Password is wrong\" }";
        }

            return "{ \"message\": \"Login successful\", \"isAdmin\": " + user.isAdmin() + "}";
    }
}
