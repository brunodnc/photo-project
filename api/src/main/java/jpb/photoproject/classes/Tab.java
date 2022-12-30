package jpb.photoproject.classes;

import java.util.ArrayList;

public class Tab {

    private Long id;
    private String name;
    private ArrayList<Photo> photos;
    private String url;
    private Boolean locked;
    private String password;
    private Integer download_limit;
    private Boolean watermark;

    public Tab(Long id, String name, ArrayList<Photo> photos, String url, Boolean locked, String password, Integer download_limit, Boolean watermark) {
        this.id = id;
        this.name = name;
        this.photos = photos;
        this.url = url;
        this.locked = locked;
        this.password = password;
        this.download_limit = download_limit;
        this.watermark = watermark;
    }
}
