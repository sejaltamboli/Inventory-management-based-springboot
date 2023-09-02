package com.infogalaxy.inventorymanagemnet.controller;


import com.infogalaxy.inventorymanagemnet.entity.item;
import com.infogalaxy.inventorymanagemnet.responses.Responses;
import com.infogalaxy.inventorymanagemnet.service.IitemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<?> addItem(@RequestBody @Valid item item1) {
        Responses responses = new Responses("Item Added Successfully",HttpStatus.CREATED,itemService.addItem(item1));
        return new ResponseEntity<>(responses, HttpStatus.CREATED);
    }

    @GetMapping("/getallitem")
    public ResponseEntity<?> getallitems() {
        return new ResponseEntity<>(new Responses("Items Found",HttpStatus.FOUND,itemService.getallitems()), HttpStatus.FOUND);
    }

    @GetMapping("/getitembyid/{id}")
    public ResponseEntity<?> getItemByID(@PathVariable("id") int id) {
        return new ResponseEntity<>(new Responses("Item Found By ID",HttpStatus.FOUND,itemService.getItemByID(id)), HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteitembyid/{id}")
    public ResponseEntity<?> deleteitembyid(@PathVariable("id") int id){
        return new ResponseEntity<>(new Responses("Item Deleted",null,itemService.deleteitembyid(id)), HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateitembyid/{id}")
    public ResponseEntity<?> updateitembyid(@PathVariable("id") int id, @RequestBody item item) {
        return new ResponseEntity<>(new Responses("Item Updated Successfully",HttpStatus.ACCEPTED,itemService.updateitembyid(id, item)),HttpStatus.PROCESSING);
    }


}
