package ru.gb.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.webapp.model.Product;
import ru.gb.webapp.repositories.ProductsRepository;


import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    public void save(Product product) {
        productsRepository.save(product);
    }

    public void plus(Product product) {
        product.setCost(product.getCost() + 1);   productsRepository.save(product);
    }

    public void minus(Product product) {
        if(product.getCost() > 0){
            product.setCost(product.getCost() - 1);
        }   productsRepository.save(product);
    }

    public Product findById(Long id) {
        return productsRepository.findById(id);
    }
}
