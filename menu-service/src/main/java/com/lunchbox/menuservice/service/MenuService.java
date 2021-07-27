package com.lunchbox.menuservice.service;

import com.lunchbox.menuservice.entity.Item;
import com.lunchbox.menuservice.entity.Restaurant;
import com.lunchbox.menuservice.exceptions.ProductNotFoundException;
import com.lunchbox.menuservice.model.RestaurantModel;
import com.lunchbox.menuservice.repo.ItemRepository;
import com.lunchbox.menuservice.repo.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private RestaurantRepository restaurantRepo;

    @Autowired
    private ItemRepository itemRepo;

    public List<Restaurant> getRestaurants(String id) {
        if (StringUtils.isEmpty(id)) {
            return restaurantRepo.findAll();
        }
        Optional<Restaurant> restaurantOpt = restaurantRepo.findById(id);
        if(restaurantOpt.isPresent()){
            return Arrays.asList(restaurantOpt.get());
        }
        throw new ProductNotFoundException("Restaurant unavailable");
    }

    public List<Item> geMenuItems(String restaurantId){
        List<Item> items = itemRepo.findByRestaurantId(restaurantId);
        if(CollectionUtils.isEmpty(items))
            throw new ProductNotFoundException("Restaurant unavailable");
        return items;
    }

    public void addRestaurant(RestaurantModel restaurant){
        Restaurant res = new Restaurant();
        res.setName(restaurant.getName());
        res.setItemCodes(restaurant.getItemCodes());
        restaurantRepo.save(res);
    };

    public void addItems(List<Item> items, String restaurantCode){
        items.forEach(i -> i.setRestaurantId(restaurantCode));
        itemRepo.saveAll(items);
    };
}
