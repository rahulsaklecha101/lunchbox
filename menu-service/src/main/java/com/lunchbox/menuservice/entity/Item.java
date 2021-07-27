package com.lunchbox.menuservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "items")
public class Item {

    @Id
    private String id;
    private String code;

    private String restaurantId;

    private String name;
    private String description;
    private double price;
    private boolean inStock = true;

}
