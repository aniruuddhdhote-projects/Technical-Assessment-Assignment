package com.example.productapi.controller;

import com.example.productapi.entity.Product;
import com.example.productapi.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public Product create(@Valid @RequestBody Product product){
        return service.create(product);
    }

    @GetMapping
    public Page<Product> getAll(@RequestParam(defaultValue="0") int page,
                                @RequestParam(defaultValue="10") int size){
        return service.getAll(page,size);
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable Long id){
        return service.get(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id,@Valid @RequestBody Product product){
        return service.update(id,product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}