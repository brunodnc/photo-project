package jpb.photoproject.classes;

import java.util.ArrayList;

public class Photographer {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private ArrayList<Client> clients;
    private Subscription subscription;

    public Photographer(Long id, String name, String username, String email, String password, ArrayList<Client> clients, Subscription subscription) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.clients = clients;
        this.subscription = subscription;
    }

}
