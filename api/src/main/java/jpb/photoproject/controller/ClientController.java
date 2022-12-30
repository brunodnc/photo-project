package jpb.photoproject.controller;

import jpb.photoproject.classes.Client;
import jpb.photoproject.dto.client.ResponseClientDTO;
import jpb.photoproject.helper.ConverterHelper;
import jpb.photoproject.helper.ResponseHelper;
import jpb.photoproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(path = "/client", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ResponseClientDTO>> get() {

        final List<Client> clients = this.clientService.findAll(true);
        return ResponseHelper.ok(
                ConverterHelper.list(clients, ResponseClientDTO.class)
        );
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
