package com.infogalaxy.inventorymanagemnet.service;

import com.infogalaxy.inventorymanagemnet.entity.item;

import java.util.ArrayList;

public interface IitemService {

    public item addItem(item item1);

    public ArrayList<item> getallitems();

    public item getitem();

}
