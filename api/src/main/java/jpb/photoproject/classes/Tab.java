package jpb.photoproject.classes;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tab")
public class Tab {

    /**
     * long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client")
    private long clientID;

    /**
     * boolean
     */

    @Column(name = "locked")
    private boolean locked;

    @Column(name = "watermark")
    private boolean watermark;

    /**
     * int
     */

    @Column(name = "download_limit")
    private Integer downloadLimit;

    /**
     * string
     */

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "password")
    private String password;

    /**
     * entity
     */

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Photo.class, mappedBy = "tabID")
    private List<Photo> photos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isWatermark() {
        return watermark;
    }

    public void setWatermark(boolean watermark) {
        this.watermark = watermark;
    }

    public Integer getDownloadLimit() {
        return downloadLimit;
    }

    public void setDownloadLimit(Integer downloadLimit) {
        this.downloadLimit = downloadLimit;
    }

    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
