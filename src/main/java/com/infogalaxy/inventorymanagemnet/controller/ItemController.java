package com.infogalaxy.inventorymanagemnet.controller;


import com.infogalaxy.inventorymanagemnet.entity.item;
import com.infogalaxy.inventorymanagemnet.service.IitemService;
import com.infogalaxy.inventorymanagemnet.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> addItem(@RequestBody item item1) {
        return new ResponseEntity<>(itemService.addItem(item1), HttpStatus.CREATED);

    }

    @GetMapping("/getallitem")
    public ResponseEntity<?> getallitems() {
        return new ResponseEntity<>(itemService.getallitems(), HttpStatus.FOUND);
    }

    @DeleteMapping("/getitembyid/{id}")
    public ResponseEntity<?> getItemByID(@PathVariable("id") int id) {
        return new ResponseEntity<>(itemService.getItemByID(id), HttpStatus.FOUND);
    }

    @GetMapping("/deleteitembyid/{id}")
    public ResponseEntity<?> deleteitembyid(@PathVariable("id") int id){
        return new ResponseEntity<>(itemService.deleteitembyid(id), HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateitembyid/{id}")
    public ResponseEntity<?> updateitembyid(@PathVariable("id") int id, @RequestBody item item) {
        return new ResponseEntity<>(itemService.updateitembyid(id, item),HttpStatus.PROCESSING);
    }


}
