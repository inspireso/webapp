/*
 * Copyright (c) 2014, Inspireso and/or its affiliates. All rights reserved.
 */

package so.inspire.example.service;

import java.util.List;

import javax.persistence.OptimisticLockException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import so.inspire.example.domain.Product;
import so.inspire.example.repository.ProductRepository;

import com.inspireso.framework.service.BusinessService;

/**
 * @author Inspireso Team
 * 
 */
@Service
public class ProductService extends BusinessService {

    @Autowired
    private ProductRepository products;

    public Product findByCode(String code) {
        return this.products.findByCode(code);
    }

    public List<Product> findAll() {
        return this.products.findAll(new Sort("code"));

    }

    public List<Product> findAll(Sort sort) {
        return products.findAll(sort);

    }

    @Transactional
    public void delete(String id, long version) {
        Product prod = this.products.findByIdAndVersion(id, version);
        if (prod == null) {
            throw new OptimisticLockException("");
        } else {
            this.products.delete(prod);
        }

    }

}
