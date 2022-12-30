package jpb.photoproject.classes;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "photo")
public class Photo {

    /**
     * long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * boolean
     */

    @Column(name = "watermark")
    private boolean watermark;

    @Column(name = "print")
    private boolean print;

    @Column(name = "downloaded")
    private boolean downloaded;

    /**
     * int
     */

    @Column(name = "tab")
    private long tabID;

    /**
     * string
     */

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "path")
    private String path;

    /**
     * date
     */

    @Column(name = "created_at")
    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public long getTabID() {
        return tabID;
    }

    public void setTabID(long tabID) {
        this.tabID = tabID;
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
