package com.lunchbox.menuservice.controller;

import com.lunchbox.menuservice.entity.Item;
import com.lunchbox.menuservice.entity.Restaurant;
import com.lunchbox.menuservice.exceptions.ProductNotFoundException;
import com.lunchbox.menuservice.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/menu")
@Slf4j
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("")
    public List<Restaurant> allRestaurants() {
        log.info("Finding all restaurants");
        return menuService.getRestaurants();
    }

    @GetMapping("/{code}")
    public List<Item> productByCode(@PathVariable String code) {
        log.info("Finding menu items for restaurant {} :", code);
        return menuService.geMenuItems(code);
    }
}
