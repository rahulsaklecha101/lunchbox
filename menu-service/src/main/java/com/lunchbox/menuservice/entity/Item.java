package com.lunchbox.menuservice.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Data
@Entity
@Table(name = "items")
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(nullable = false, unique = true)
    private String code;

    @OneToOne
    private Restaurant restaurant;

    @Column(nullable = false)
    private String name;
    private String description;
    private double price;
    private boolean inStock = true;

}
