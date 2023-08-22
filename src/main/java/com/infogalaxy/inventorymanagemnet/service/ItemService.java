package com.infogalaxy.inventorymanagemnet.service;

import com.infogalaxy.inventorymanagemnet.entity.item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ItemService implements IitemService{

    ArrayList<item> itemArrayList = new ArrayList<>();

    @Override
    public item addItem(item item1){
        itemArrayList.add(item1);
        return item1;
    }

    @Override
    public ArrayList<item> getallitems(){
        return itemArrayList;
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
