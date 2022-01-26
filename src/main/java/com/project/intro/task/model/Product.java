package com.project.intro.task.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private int quantity;

    public Product update(Product product){
        if (this.id != null && product != null && this.id.equals(product.getId())){
            if (product.getName() != null) { this.name = product.getName();}
            if (product.getQuantity() >= 0) { this.quantity = product.getQuantity();}
        }
        return this;
    }
}
