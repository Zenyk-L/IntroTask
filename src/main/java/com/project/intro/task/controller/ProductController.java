package com.project.intro.task.controller;

import com.project.intro.task.model.Product;
import com.project.intro.task.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id){
        return productService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<Product> getAllProducts(){
        return productService.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public Product createProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product){
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
