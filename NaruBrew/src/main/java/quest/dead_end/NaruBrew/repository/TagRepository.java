package quest.dead_end.NaruBrew.repository;

import quest.dead_end.NaruBrew.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long>
{
    Tag findByName(String name);
}
