package jpb.photoproject.classes;

import java.util.ArrayList;
import java.util.Date;

public class Client {

    private Long id;
    private String name;
    private ArrayList<String> tabs; // TODO: change to tabs
    private Date created_at;
    private Date updated_at;
    private Long photographer; // TODO: change to photographer

    public Client(Long id, String name, ArrayList<String> tabs, Date created_at, Date updated_at, Long photographer) {
        this.id = id;
        this.name = name;
        this.tabs = tabs;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.photographer = photographer;
    }


}
