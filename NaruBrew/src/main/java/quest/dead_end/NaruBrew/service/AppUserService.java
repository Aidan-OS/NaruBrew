package quest.dead_end.NaruBrew.service;

import quest.dead_end.NaruBrew.model.AppUser;
import quest.dead_end.NaruBrew.repositories.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
    private final AppUserRepository repo;
    private final PasswordEncoder encoder;

    public AppUserService(AppUserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public boolean registerUser(String username, String email, String rawPassword) {
        if (repo.findByUsername(username).isPresent()) {
            return false; // user already exists
        }

        AppUser user = new AppUser();
        user.setUsername(username);
        user.setEmail(email);
        user.setPasswordHash(encoder.encode(rawPassword));
        repo.save(user);
        return true;
    }
}

