package com.infogalaxy.inventorymanagemnet.controller;


import com.infogalaxy.inventorymanagemnet.entity.item;
import com.infogalaxy.inventorymanagemnet.service.IitemService;
import com.infogalaxy.inventorymanagemnet.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/item/api")
public class ItemController {

    //ItemService itemService = new ItemService();


    @Autowired
    IitemService itemService;

    @GetMapping("home")
    public String homepage() {
        return "Welcome to Item API";
    }

    @PostMapping("/additem")
    public item addItem(@RequestBody item item1) {
        return itemService.addItem(item1);

    }

    @GetMapping("/getitem")
    public item getitem() {
        return itemService.getitem();
    }

    @GetMapping("/getallitem")
    public List<item> getallitems() {
        return itemService.getallitems();
    }
}
