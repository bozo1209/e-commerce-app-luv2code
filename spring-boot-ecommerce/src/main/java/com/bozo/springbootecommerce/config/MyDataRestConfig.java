package com.bozo.springbootecommerce.config;

import com.bozo.springbootecommerce.entity.Product;
import com.bozo.springbootecommerce.entity.ProductCategory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.Type;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] unsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        config
                .getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metaData, httpMethods) -> httpMethods.disable(unsupportedActions))
                .withCollectionExposure((metaData, httpMethods) -> httpMethods.disable(unsupportedActions));

        config
                .getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metaData, httpMethods) -> httpMethods.disable(unsupportedActions))
                .withCollectionExposure((metaData, httpMethods) -> httpMethods.disable(unsupportedActions));

        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {

        config.exposeIdsFor(
                        entityManager
                                .getMetamodel()
                                .getEntities()
                                .stream()
                                .map(Type::getJavaType)
                                .toList()
                                .toArray(new Class[0])
                );
    }
}
