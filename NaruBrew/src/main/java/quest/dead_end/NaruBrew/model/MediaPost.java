package quest.dead_end.NaruBrew.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class MediaPost
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1024)
    private String description;

    private String filePath;
    private String mediaType;

    @ManyToMany
    @JoinTable(
            name = "media_tags",
            joinColumns = @JoinColumn(name = "media_post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

    @ManyToOne
    private User uploader;

    private LocalDateTime uploadedAt;

    // Getters and setters
}
