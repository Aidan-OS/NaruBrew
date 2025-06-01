package quest.dead_end.NaruBrew.repositories;


import quest.dead_end.NaruBrew.model.MediaPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaPostRepository extends JpaRepository<MediaPost, Long>
{
    List<MediaPost> findByTitleContainingIgnoreCase(String keyword);
}