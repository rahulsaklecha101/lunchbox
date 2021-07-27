package com.lunchbox.menuservice.controller;

import com.lunchbox.menuservice.entity.Item;
import com.lunchbox.menuservice.entity.Restaurant;
import com.lunchbox.menuservice.model.RestaurantModel;
import com.lunchbox.menuservice.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
@Slf4j
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("")
    public List<Restaurant> allRestaurants() {
        log.info("Get all restaurants");
        return menuService.getRestaurants(null);
    }

    @GetMapping("/{id}")
    public List<Restaurant> getRestaurant(@PathVariable String restaurantId) {
        log.info("Get restaurant for restaurant Id : {}", restaurantId);
        return menuService.getRestaurants(restaurantId);
    }

    @GetMapping("/items/{id}")
    public List<Item> getItems(@PathVariable("id") String restaurantId) {
        log.info("Finding menu items for restaurant id {} :", restaurantId);
        return menuService.geMenuItems(restaurantId);
    }

    @PutMapping("/add")
    public void addRestaurant(@RequestBody RestaurantModel body){
        log.info("Adding new restaurant",body.toString());
        menuService.addRestaurant(body);
    }

    @PutMapping("/items/{id}/add")
    public void addItems(@PathVariable("id") String restaurantId, @RequestBody List<Item> body){
        log.info("Adding items for restaurant : {}, items : {}", restaurantId, body.toString());
        menuService.addItems(body, restaurantId);
    }
}
