package com.infogalaxy.inventorymanagemnet.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemModel {

    //private int id;
    @NotBlank(message = "Please Enter the Item Name")
    private String name;
    @NotBlank(message = "Please Enter the Description")
    private String description;
    private int price;
    private int quantity;
    private String status;
}
