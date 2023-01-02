package jpb.photoproject.controller;

import jpb.photoproject.classes.Tab;
import jpb.photoproject.dto.tab.RequestTabDTO;
import jpb.photoproject.dto.tab.ResponseTabDTO;
import jpb.photoproject.helper.ConverterHelper;
import jpb.photoproject.helper.ResponseHelper;
import jpb.photoproject.service.TabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;
import java.util.List;

public class TabController {
    @Autowired
    private TabService tabService;

    @GetMapping(path = "/tab/{clientId}")
    public ResponseEntity<List<ResponseTabDTO>> GetTabsByClientid(@PathVariable Long clientId) {

        List<Tab> tabs = this.tabService.findByClientId(clientId);

        return ResponseHelper.ok(ConverterHelper.list(tabs, ResponseTabDTO.class));
    }

    @PostMapping(path = "/tab")
    public ResponseEntity<ResponseTabDTO> PostTab(@RequestBody RequestTabDTO newTab) {

        Tab tab = ConverterHelper.converts(newTab, Tab.class);

        Tab createdTab = this.tabService.postTab(tab);

        return ResponseHelper.ok(ConverterHelper.converts(createdTab, ResponseTabDTO.class));
    }


}
