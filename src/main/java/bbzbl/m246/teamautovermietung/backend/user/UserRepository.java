package bbzbl.m246.teamautovermietung.backend.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long>{
    public UserModel findByUsername(String username);
    public UserModel findByEmail(String email);
    public List<UserModel> findByIsAdmin(boolean isAdmin);
    public List<UserModel> findByEnabled(boolean enabled);
}
