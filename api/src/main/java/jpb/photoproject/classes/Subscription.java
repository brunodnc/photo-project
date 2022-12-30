package jpb.photoproject.classes;

import jakarta.persistence.*;

@Entity
@Table(name = "subscription")
public class Subscription {

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

    public Subscription() {
    }

    public Subscription(String name, Long id) {
        this.name = name;
        this.id = id;
    }

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
}
