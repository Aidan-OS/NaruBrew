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
