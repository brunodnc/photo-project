package jpb.photoproject.classes;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "photographer")
public class Photographer {

    /**
     * long
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * string
     */

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    /**
     * entity
     */

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Client.class, mappedBy = "photographerID")
    private List<Client> clients;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Subscription.class)
    @JoinColumn(name = "subscription", referencedColumnName = "id")
    private Subscription subscription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
}
