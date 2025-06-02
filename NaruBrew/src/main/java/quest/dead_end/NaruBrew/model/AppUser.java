package quest.dead_end.NaruBrew.model;

import jakarta.persistence.*;

@Entity
public class AppUser
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String passwordHash;

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return(this.username);
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    public void setPasswordHash(String passwordHash)
    {
        this.passwordHash = passwordHash;
    }

    public String getPasswordHash()
    {
        return passwordHash;
    }

}
