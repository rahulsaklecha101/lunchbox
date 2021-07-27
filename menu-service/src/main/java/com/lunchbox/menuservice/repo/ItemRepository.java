package com.lunchbox.menuservice.repo;

import com.lunchbox.menuservice.entity.Item;
import com.lunchbox.menuservice.entity.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

    List<Item> findByRestaurantId(String restaurantId);

}
