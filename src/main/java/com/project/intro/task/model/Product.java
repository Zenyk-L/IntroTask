package com.project.intro.task.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
//@Builder
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private int quantity;

    public Product() {
    }
}
