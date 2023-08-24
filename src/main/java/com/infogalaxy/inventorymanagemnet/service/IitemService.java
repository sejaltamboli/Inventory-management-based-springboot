package com.infogalaxy.inventorymanagemnet.service;

import com.infogalaxy.inventorymanagemnet.entity.item;

import java.util.List;
import java.util.Optional;

public interface IitemService {

    public item addItem(item item1);

    public List<item> getallitems();

    public Optional<item> getItemByID(int id);

    public String deleteitembyid(int id);

    public item updateitembyid(int id, item item);


}
