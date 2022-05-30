package ru.gb.webapp.repositories;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

import ru.gb.webapp.model.*;
@Component
public class ProductsRepository {
    private List<Product> productList;

    @PostConstruct
    public void init() {
        this.productList = new ArrayList<>(Arrays.asList(
                new Product(1L, "Яблоки сезонные", 89),
                new Product(2L, "Батон нарезной", 56),
                new Product(3L, "Сыр костромской", 567),
                new Product(4L, "Свинина лопатка", 340),
                new Product(5L, "Фарш домашний", 299))
        );
    }

    public List<Product> findAll() {
        productList.sort(Comparator.comparingLong(Product::getId));
        return Collections.unmodifiableList(productList);
        }

    public void save(Product product) {
        Long id = product.getId();
        Product productFind = productList.stream().filter(s -> s.getId().equals(id)).findFirst().get();
        if(productFind == null) {
            productList.add(product);
        }else {
            productList.remove(productFind);
            productList.add(product);
        }
    }

    public Product findById(Long id) {
        return productList.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }
}
