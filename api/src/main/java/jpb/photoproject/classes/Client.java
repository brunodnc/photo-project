package jpb.photoproject.classes;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "client")
public class Client {

    /**
     * long
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "photographer")
    private long photographerID;

    /**
     * string
     */

    @Column(name = "name")
    private String name;

    /**
     * date
     */

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;


    /**
     * entity
     */

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Tab.class, mappedBy = "clientID")
    private List<Tab> tabs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getPhotographerID() {
        return photographerID;
    }

    public void setPhotographerID(long photographerID) {
        this.photographerID = photographerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Tab> getTabs() {
        return tabs;
    }

    public void setTabs(List<Tab> tabs) {
        this.tabs = tabs;
    }
}
