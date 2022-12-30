package jpb.photoproject.classes;

import java.util.Date;

public class Photo {

    private Long id;
    private String file_name;
    private String path;
    private Boolean watermark;
    private Boolean print;
    private Boolean downloaded;
    private Date created_at;
    private Long tab;

    public Photo(Long id, String file_name, String path, Boolean watermark, Boolean print, Boolean downloaded, Date created_at, Long tab) {
        this.id = id;
        this.file_name = file_name;
        this.watermark = watermark;
        this.print = print;
        this.downloaded = downloaded;
        this.created_at = created_at;
        this.tab = tab;
    }

}
