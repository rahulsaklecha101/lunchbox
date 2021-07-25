package com.lunchbox.menuservice.service;

import com.lunchbox.menuservice.entity.Item;
import com.lunchbox.menuservice.entity.Restaurant;
import com.lunchbox.menuservice.exceptions.ProductNotFoundException;
import com.lunchbox.menuservice.repo.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private RestaurantRepository restaurantRepo;

    public List<Restaurant> getRestaurants(){
        return restaurantRepo.findAll();
    }

    public List<Item> geMenuItems(String restaurantCode){
        Optional<Restaurant> opt = restaurantRepo.findByCode(restaurantCode);
        if(opt.isPresent()){
            return opt.get().getItems();
        }
        throw new ProductNotFoundException("Restaurant unavailable");
    };
}
