package jpb.photoproject.dto.tab;

import jpb.photoproject.dto.photo.RequestPhotoDTO;

import java.util.List;

public class RequestTabDTO {

    /**
     * long
     */

    private Long id;
    private long clientID;

    /**
     * boolean
     */

    private boolean locked;
    private boolean watermark;

    /**
     * int
     */

    private Integer downloadLimit;

    /**
     * string
     */

    private String name;

    private String url;

    private String password;

    /**
     * list
     */

    private List<RequestPhotoDTO> photos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
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

    public List<RequestPhotoDTO> getPhotos() {
        return photos;
    }

    public void setPhotos(List<RequestPhotoDTO> photos) {
        this.photos = photos;
    }
}
