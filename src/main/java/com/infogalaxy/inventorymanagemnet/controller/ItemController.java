package com.infogalaxy.inventorymanagemnet.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item/api")
public class ItemController {

    @GetMapping("home")
    public String homepage() {
        return "Welcome to Item API";
    }

    @PostMapping("/additem")
    public String addItem() {
        return "Item Added";


    }
}
