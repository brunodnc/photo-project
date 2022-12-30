package jpb.photoproject.controller;

import jpb.photoproject.classes.Client;
import jpb.photoproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(path="/client", produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
    public ResponseEntity<Client> get() {
        System.out.println(this.clientService.recuperar());
        return new ResponseEntity("Clientes recuperados", HttpStatus.OK);
    }

    @GetMapping(path = "/client/{photographerId}")
    public ResponseEntity<Client> GetClientsByPhotographerId(@PathVariable Long photographerId) {
        // System.out.println(this.clientService.recuperar());

        return new ResponseEntity<>(null);
    }

    @PostMapping(path = "/client/")
    public ResponseEntity<Client> PostClient(@RequestBody Client client) {
        // needs to check for client name here?
        // send client to service for creation
        // sets response as created Client

        return new ResponseEntity<>(HttpStatusCode.valueOf(201));
    }
}
