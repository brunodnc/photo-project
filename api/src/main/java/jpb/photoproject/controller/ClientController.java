package jpb.photoproject.controller;

import jpb.photoproject.classes.Client;
import jpb.photoproject.dto.client.RequestClientDTO;
import jpb.photoproject.dto.client.ResponseClientDTO;
import jpb.photoproject.helper.ConverterHelper;
import jpb.photoproject.helper.ResponseHelper;
import jpb.photoproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<ResponseClientDTO>> GetClientsByPhotographerId(@PathVariable Long photographerId) {

        final List<Client> clients = this.clientService.findAllByPhotographerId(true, photographerId);

        return ResponseHelper.ok(
                ConverterHelper.list(clients, ResponseClientDTO.class)
        );
    }

    @PostMapping(path = "/client/")
    public ResponseEntity<ResponseClientDTO> PostClient(@RequestBody RequestClientDTO requestClient) {

        // CHECK: Conversion to entity here?

        Client clientEntity = ConverterHelper.converts(requestClient, Client.class);

        // send client to service for creation
        final Client newClient = this.clientService.postClient(clientEntity);
        // sets response as created Client

        return ResponseHelper.ok(
                ConverterHelper.converts(newClient, ResponseClientDTO.class)
        );
    }
}
