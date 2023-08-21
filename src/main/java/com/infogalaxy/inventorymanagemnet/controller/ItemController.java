package com.infogalaxy.inventorymanagemnet.controller;


import com.infogalaxy.inventorymanagemnet.entity.item;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/item/api")
public class ItemController {

    ArrayList<item> itemArrayList = new ArrayList<>();
    @GetMapping("home")
    public String homepage() {
        return "Welcome to Item API";
    }

    @PostMapping("/additem")
    public item addItem(@RequestBody item item1) {
        itemArrayList.add(item1);
        return item1;
    }

    @GetMapping("/getitem")
    public item getitem() {
          item item1 = new item();
          item1.setId(1);
          item1.setName("Pen");
          item1.setDescription("Gel Pen");
          item1.setPrice(5);
          item1.setQuantity(100);
          item1.setStatus("Available");
          return item1;
    }

    @GetMapping("/getallitem")
    public ArrayList<item> getallitems() {
        return itemArrayList;
    }
}
