package com.bozo.springbootecommerce.bootsrap;

import com.bozo.springbootecommerce.dao.ProductCategoryRepository;
import com.bozo.springbootecommerce.dao.ProductRepository;
import com.bozo.springbootecommerce.entity.Product;
import com.bozo.springbootecommerce.entity.ProductCategory;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private ProductRepository productRepository;
    private ProductCategoryRepository productCategoryRepository;
    @Override
    public void run(String... args) throws Exception {

        ProductCategory productCategory = productCategoryRepository.save(ProductCategory.builder().build());

        productRepository.save(Product.builder()
                .sku("BOOK-TECH-1000")
                .name("JavaScript - The Fun Parts")
                .description("Learn JavaScript")
                .imageUrl("assets/images/products/placeholder.png")
                .active(true)
                .unitsInStock(100)
                .unitPrice(new BigDecimal("19.99"))
                .dateCreated(new Date())
                .category(productCategory)
                .build());

        productRepository.save(Product.builder()
                .sku("BOOK-TECH-1001")
                .name("Spring Framework Tutorial")
                .description("Learn Spring")
                .imageUrl("assets/images/products/placeholder.png")
                .active(true)
                .unitsInStock(100)
                .unitPrice(new BigDecimal("29.99"))
                .dateCreated(new Date())
                .category(productCategory)
                .build());

        productRepository.save(Product.builder()
                .sku("BOOK-TECH-1002")
                .name("Kubernetes - Deploying Containers")
                .description("Learn Kubernetes")
                .imageUrl("assets/images/products/placeholder.png")
                .active(true)
                .unitsInStock(100)
                .unitPrice(new BigDecimal("24.99"))
                .dateCreated(new Date())
                .category(productCategory)
                .build());

    }
}
