package com.project.intro.task.service;

import com.project.intro.task.dao.ProductRepository;
import com.project.intro.task.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product){
        log.info("Save product " + product);
        return productRepository.save(product);
    }

    public Product getById(int id){
        log.info("Get product by id " + id);
        return productRepository.findById(id).get();
    }

    public Product update(Integer id, Product product){
        product.setId(id);
        Product productFromBD = productRepository.findById(id).get();
        if (productFromBD != null) {
            productFromBD.update(product);
            productRepository.save(productFromBD);
            log.info("Update product " + productFromBD);
        }
        return productFromBD;
    }

    public void delete(Integer id){
        productRepository.deleteById(id);
        log.info("Delete product by id " + id);

    }

    public List<Product> getAll(){
        log.info("Get all products : ");
        return productRepository.findAll();
    }
}
