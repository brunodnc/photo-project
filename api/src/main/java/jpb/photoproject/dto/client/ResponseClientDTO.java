package jpb.photoproject.dto.client;

import jpb.photoproject.dto.tab.ResponseTabDTO;

import java.util.Date;
import java.util.List;

public class ResponseClientDTO {

    /**
     * id
     */

    private Long id;
    private long photographerID;

    /**
     * string
     */

    private String name;

    /**
     * date
     */

    private Date createdAt;
    private Date updatedAt;


    /**
     * list
     */

    private List<ResponseTabDTO> tabs;

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

    public List<ResponseTabDTO> getTabs() {
        return tabs;
    }

    public void setTabs(List<ResponseTabDTO> tabs) {
        this.tabs = tabs;
    }
}
