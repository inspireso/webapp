/*
 * Copyright (c) 2014, Inspireso and/or its affiliates. All rights reserved.
 */

package so.inspire.example.service;

import java.util.List;

import javax.persistence.OptimisticLockException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import so.inspire.example.domain.Pricelist;
import so.inspire.example.repository.PricelistRepository;

import com.inspireso.framework.service.BusinessService;

/**
 * @author Inspireso Team
 * 
 */
@Service
public class PricelistService extends BusinessService {

    @Autowired
    private PricelistRepository pricelists;

    /**
     * @param id
     * @return
     */
    public Pricelist find(String id) {
        return pricelists.findOne(id);
    }

    public List<Pricelist> findAll() {
        return pricelists.findAll();

    }

    public List<Pricelist> findByProduct(String code) {
        return pricelists.findByProductCode(code);

    }

    @Transactional
    public void delete(String id, long version) {
        Pricelist entity = this.pricelists.findByIdAndVersion(id, version);
        if (entity == null) {
            throw new OptimisticLockException(this.pricelists.findOne(id));
        }
        this.pricelists.delete(id);

    }

}
