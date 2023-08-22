package com.infogalaxy.inventorymanagemnet.service;

import com.infogalaxy.inventorymanagemnet.entity.item;
import com.infogalaxy.inventorymanagemnet.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService implements IitemService{

    @Autowired
    ItemRepo itemRepo;

    @Override
    public item addItem(item item1){
        itemRepo.save(item1);
        return item1;
    }

    @Override
    public List<item> getallitems(){
        return itemRepo.findAll();
    }

    @Override
    public item getitem(){
        item item1 = new item();
        item1.setId(1);
        item1.setName("Pen");
        item1.setDescription("Gel Pen");
        item1.setPrice(5);
        item1.setQuantity(10);
        item1.setStatus("Available");
        return item1;

    }
}
