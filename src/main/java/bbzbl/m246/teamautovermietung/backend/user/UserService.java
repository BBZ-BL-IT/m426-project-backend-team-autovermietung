package bbzbl.m246.teamautovermietung.backend.user;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserModel getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserModel getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<UserModel> getAdminUsers() {
        return userRepository.findByIsAdmin(true);
    }

    public List<UserModel> getEnabledUsers() {
        return userRepository.findByEnabled(true);
    }

    public List<UserModel> getDisabledUsers() {
        return userRepository.findByEnabled(false);
    }

    public UserModel createUser(UserModel user) {
        if (userRepository.findByUsername(user.getUsername()) != null || userRepository.findByEmail(user.getEmail()) != null){
            throw new IllegalArgumentException("Username " + user.getUsername() + " already exists");
            
        }
        return userRepository.save(user);
    }

    public UserModel updateUser(UserModel user) {
        if (!userRepository.existsById(user.getId())) {
            throw new IllegalArgumentException("User with id " + user.getId() + " does not exist");
        }
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User with id " + id + " does not exist");
        }
        userRepository.deleteById(id);
    }
}
