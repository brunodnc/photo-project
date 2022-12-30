package jpb.photoproject.dto.photo;

import java.util.Date;

public class RequestPhotoDTO {

    /**
     * id
     */

    private Long id;
    private long tabID;

    /**
     * boolean
     */

    private boolean watermark;
    private boolean print;
    private boolean downloaded;

    /**
     * string
     */

    private String fileName;
    private String path;

    /**
     * date
     */

    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getTabID() {
        return tabID;
    }

    public void setTabID(long tabID) {
        this.tabID = tabID;
    }

    public boolean isWatermark() {
        return watermark;
    }

    public void setWatermark(boolean watermark) {
        this.watermark = watermark;
    }

    public boolean isPrint() {
        return print;
    }

    public void setPrint(boolean print) {
        this.print = print;
    }

    public boolean isDownloaded() {
        return downloaded;
    }

    public void setDownloaded(boolean downloaded) {
        this.downloaded = downloaded;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
