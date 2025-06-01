package quest.dead_end.NaruBrew.repositories;

import quest.dead_end.NaruBrew.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long>
{
    Optional<AppUser> findByUsername(String username);
}
