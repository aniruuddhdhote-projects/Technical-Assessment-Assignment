package com.example.productapi.service;

import com.example.productapi.entity.Product;
import com.example.productapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product create(Product product){
        return repository.save(product);
    }

    public Page<Product> getAll(int page,int size){
        return repository.findAll(PageRequest.of(page,size,Sort.by("id").descending()));
    }

    public Product get(Long id){
        return repository.findById(id).orElseThrow();
    }

    public Product update(Long id, Product product){
        Product existing = repository.findById(id).orElseThrow();
        existing.setProductName(product.getProductName());
        return repository.save(existing);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}