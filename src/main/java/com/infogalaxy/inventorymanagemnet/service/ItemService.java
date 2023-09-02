package com.infogalaxy.inventorymanagemnet.service;

import com.infogalaxy.inventorymanagemnet.entity.item;
import com.infogalaxy.inventorymanagemnet.exception.ItemNotFoundException;
import com.infogalaxy.inventorymanagemnet.model.ItemModel;
import com.infogalaxy.inventorymanagemnet.repo.ItemRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements IitemService{

    @Autowired
    ItemRepo itemRepo;

    @Override
    public item addItem(ItemModel itemModel){
        item item1 = new item();
//        item1.setId(itemModel.getId());
//        item1.setName(itemModel.getName());
//        item1.setDescription(itemModel.getDescription());
//        item1.setPrice(itemModel.getPrice());
//        item1.setQuantity(itemModel.getQuantity());
//        item1.setStatus(itemModel.getStatus());
        BeanUtils.copyProperties(itemModel,item1);
        itemRepo.save(item1);
        return item1;
    }

    @Override
    public List<item> getallitems(){
        return itemRepo.findAll();
    }


    @Override
    public Optional<item> getItemByID(int id) {
        Optional<item> item = itemRepo.findById(id);
        if (item.isPresent()) {
            return item;
        } else {
            throw new ItemNotFoundException("Item with Given ID not Found in Database");
        }
    }

    @Override
    public String deleteitembyid(int id){
        item item = itemRepo.findById(id).get();
        itemRepo.delete(item);
        return "Item Deleted Successfully...";
    }

    @Override
    public item updateitembyid(int id, item item) {
        item olditem = itemRepo.findById(id).get();
        olditem.setName(item.getName());
        olditem.setDescription(item.getDescription());
        olditem.setPrice(item.getPrice());
        olditem.setQuantity(item.getQuantity());
        olditem.setStatus(item.getStatus());
        return itemRepo.save(olditem);
    }

}
