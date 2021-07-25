package com.lunchbox.menuservice.repo;

import com.lunchbox.menuservice.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {
    Optional<Restaurant> findByCode(String code);
}
