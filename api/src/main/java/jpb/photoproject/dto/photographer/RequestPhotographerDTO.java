package jpb.photoproject.dto.photographer;

import jpb.photoproject.dto.client.RequestClientDTO;
import jpb.photoproject.dto.subscription.RequestSubscriptionDTO;

import java.util.List;

public class RequestPhotographerDTO {


    /**
     * long
     */

    private Long id;

    /**
     * string
     */

    private String name;
    private String username;
    private String email;
    private String password;

    /**
     * list
     */

    private List<RequestClientDTO> clients;

    /**
     * dto
     */

    private RequestSubscriptionDTO subscription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RequestClientDTO> getClients() {
        return clients;
    }

    public void setClients(List<RequestClientDTO> clients) {
        this.clients = clients;
    }

    public RequestSubscriptionDTO getSubscription() {
        return subscription;
    }

    public void setSubscription(RequestSubscriptionDTO subscription) {
        this.subscription = subscription;
    }
}
