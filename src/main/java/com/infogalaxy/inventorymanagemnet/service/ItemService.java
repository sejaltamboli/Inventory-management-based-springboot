package com.infogalaxy.inventorymanagemnet.service;

import com.infogalaxy.inventorymanagemnet.entity.item;
import com.infogalaxy.inventorymanagemnet.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public item getItemByID(int id) {
        return itemRepo.findById(id).get();
    }

    @Override
    public String deleteitembyid(int id){
        item item = getItemByID(id);
        itemRepo.delete(item);
        return "Item Deleted Successfully...";
    }

    @Override
    public item updateitembyid(int id, item item) {
        item olditem = getItemByID(id);
        olditem.setName(item.getName());
        olditem.setDescription(item.getDescription());
        olditem.setPrice(item.getPrice());
        olditem.setQuantity(item.getQuantity());
        olditem.setStatus(item.getStatus());
        return itemRepo.save(olditem);
    }
}
