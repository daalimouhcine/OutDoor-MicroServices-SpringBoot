package com.service.product.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.service.product.model.Product;
import com.service.product.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class DatabaseChangeLog {

    @ChangeSet(order = "001", id = "createProductCollection", author = "mouhcine")
    public void seedDatabase(ProductRepository productRepository) {
        List<Product> productList = new ArrayList<>();
        productList.add(createNewProduct("Travel Bag", "A travel bag for your next trip", BigDecimal.valueOf(100)));
        productList.add(createNewProduct("Headphones", "A headphones for your next trip", BigDecimal.valueOf(200)));
        productList.add(createNewProduct("Camera", "A camera for your next trip", BigDecimal.valueOf(300)));
        productList.add(createNewProduct("Watch", "A watch for your next trip", BigDecimal.valueOf(400)));
        productList.add(createNewProduct("Shoes", "A shoes for your next trip", BigDecimal.valueOf(500)));
        productList.add(createNewProduct("Sunglasses", "A sunglasses for your next trip", BigDecimal.valueOf(600)));
        productList.add(createNewProduct("T-shirt", "A t-shirt for your next trip", BigDecimal.valueOf(700)));
        productList.add(createNewProduct("Pants", "A pants for your next trip", BigDecimal.valueOf(800)));

        productRepository.insert(productList);

    }

    private Product createNewProduct(String name, String description, BigDecimal price) {
        return Product.builder()
                .name(name)
                .description(description)
                .price(price)
                .build();
    }


}
