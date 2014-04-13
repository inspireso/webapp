/*
 * Copyright (c) 2014, Inspireso and/or its affiliates. All rights reserved.
 */

package so.inspire.example.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import so.inspire.example.domain.Pricelist;

import com.inspireso.framework.repository.BusinessRepository;

/**
 * @author Inspireso Team
 * 
 */
@Repository
public interface PricelistRepository extends BusinessRepository<Pricelist> {

    List<Pricelist> findByProductCode(String code);

}
