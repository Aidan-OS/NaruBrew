package quest.dead_end.NaruBrew.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Artist
{
    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "artists")
    private List<MediaPost> mediaList;

    public Artist() {}

    public Artist(String name)
    {
        this.name = name;
    }

    public Long getId()
    {
        return(id);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return(this.name);
    }

    public void setMediaList(List<MediaPost> mediaList)
    {
        this.mediaList = mediaList;
    }

    public List<MediaPost> getMediaList()
    {
        return(this.mediaList);
    }
}
