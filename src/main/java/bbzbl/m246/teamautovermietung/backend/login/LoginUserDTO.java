package bbzbl.m246.teamautovermietung.backend.login;

import lombok.Data;

@Data
public class LoginUserDTO {
    private String username;
    private String password;

    public LoginUserDTO() {
    }

    public LoginUserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
