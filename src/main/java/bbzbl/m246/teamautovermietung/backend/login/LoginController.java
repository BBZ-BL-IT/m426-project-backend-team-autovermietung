package bbzbl.m246.teamautovermietung.backend.login;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public ResponseEntity<String> login(@RequestBody LoginUserDTO loginUser) {
        String response = loginService.login(loginUser);
        
        switch (response) {
            case "User not found":
                return ResponseEntity.notFound().build();
            case "Wrong password":
                return ResponseEntity.badRequest().build();
            default:
                break;
        }
        return ResponseEntity.ok(response);
    }
    
}
