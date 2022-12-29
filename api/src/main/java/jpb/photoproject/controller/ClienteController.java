package jpb.photoproject.controller;

import jpb.photoproject.dao.ClienteDAO;
import jpb.photoproject.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(path = "/cliente", produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> get() {
        System.out.println(this.clienteService.recuperar());
        return new ResponseEntity("Clientes recuperados", HttpStatus.OK);
    }
}
