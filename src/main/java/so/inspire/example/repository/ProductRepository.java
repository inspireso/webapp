/*
 * Copyright (c) 2014, Inspireso and/or its affiliates. All rights reserved.
 */

package so.inspire.example.repository;

import org.springframework.stereotype.Repository;

import so.inspire.example.domain.Product;

import com.inspireso.framework.repository.BusinessRepository;

/**
 * @author Inspireso Team
 * 
 */
@Repository
public interface ProductRepository extends BusinessRepository<Product> {

    Product findByCode(String code);

}
