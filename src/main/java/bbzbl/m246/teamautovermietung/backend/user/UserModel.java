package bbzbl.m246.teamautovermietung.backend.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "username", nullable = false)
    private String username;
    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "is_admin", nullable = false, columnDefinition = "boolean default false")
    private boolean isAdmin;
    @Column(name = "enabled", nullable = false, columnDefinition = "boolean default true")
    private boolean enabled;

    public String toString() {
        return "{ \"id\": " + id + ", \"username\": \"" + username + "\", \"email\": \"" + email + "\", \"isAdmin\": " + isAdmin + ", \"enabled\": " + enabled + "}";
    }
}
