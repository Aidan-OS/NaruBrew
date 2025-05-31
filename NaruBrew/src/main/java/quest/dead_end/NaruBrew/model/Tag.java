package quest.dead_end.NaruBrew.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Tag
{
    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<MediaPost> mediaList;

}
