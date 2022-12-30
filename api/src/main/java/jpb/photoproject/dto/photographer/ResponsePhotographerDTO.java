package jpb.photoproject.dto.photographer;

import jpb.photoproject.dto.client.ResponseClientDTO;
import jpb.photoproject.dto.subscription.ResponseSubscriptionDTO;

import java.util.List;

public class ResponsePhotographerDTO {

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

    private List<ResponseClientDTO> clients;

    /**
     * dto
     */

    private ResponseSubscriptionDTO subscription;

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

    public List<ResponseClientDTO> getClients() {
        return clients;
    }

    public void setClients(List<ResponseClientDTO> clients) {
        this.clients = clients;
    }

    public ResponseSubscriptionDTO getSubscription() {
        return subscription;
    }

    public void setSubscription(ResponseSubscriptionDTO subscription) {
        this.subscription = subscription;
    }
}
