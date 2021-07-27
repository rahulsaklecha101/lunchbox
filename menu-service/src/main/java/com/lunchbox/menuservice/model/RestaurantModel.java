package com.lunchbox.menuservice.model;

import lombok.Data;

import java.util.List;

@Data
public class RestaurantModel {

    private String name;
    private List<String> itemCodes;
}
