package quest.dead_end.NaruBrew.service;

import quest.dead_end.NaruBrew.model.AppUser;
import quest.dead_end.NaruBrew.repositories.AppUserRepository;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService
{

    private final AppUserRepository userRepo;

    public CustomUserDetailsService(AppUserRepository userRepo)
    {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        AppUser user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return User.builder()
                .username(user.getUsername())
                .password(user.getPasswordHash()) // hashed password from DB
                .roles("USER") // or use user.getRole() if you support roles
                .build();
    }
}
