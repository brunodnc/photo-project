package jpb.photoproject.controller;

import jpb.photoproject.classes.Tab;
import jpb.photoproject.service.TabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;

public class TabController {
    @Autowired
    private TabService clientService;

    @GetMapping(path = "/tab/{clientId}")
    public ResponseEntity<ArrayList<Tab>> GetTabsByClientid(@PathVariable Long clientId) {
        System.out.println(clientId);
        // this.clientService.recuperar();
        return new ResponseEntity("Tabs recuperadas", HttpStatus.OK);
    }

    @PostMapping(path = "/tab")
    public ResponseEntity<Tab> PostTab(@RequestBody Tab newTab) {
        System.out.println(newTab);
        return new ResponseEntity<>(null);
    }


}
