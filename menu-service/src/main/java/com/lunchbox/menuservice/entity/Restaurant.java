package com.lunchbox.menuservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "restaurants")
public class Restaurant {

    @Id
    private String id;
    private String name;
    private List<String> itemCodes;

}
