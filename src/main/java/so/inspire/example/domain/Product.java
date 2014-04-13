/*
 * Copyright (c) 2014, Inspireso and/or its affiliates. All rights reserved.
 */

package so.inspire.example.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import so.inspire.example.domain.base.AbstractCode;

import com.inspireso.framework.context.BeanBuilder;

/**
 * @author Inspireso Team
 * 
 */
@Entity
@Table(name = "exp_product")
public class Product extends AbstractCode implements BeanBuilder<Product> {

    private static final long serialVersionUID = 1L;

    private int orderBy;

    private boolean support;

    /**
     * @return the orderBy
     */
    public int getOrderBy() {
        return orderBy;
    }

    /**
     * @param orderBy the orderBy to set
     */
    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * @return the support
     */
    public boolean isSupport() {
        return support;
    }

    /**
     * @param support the support to set
     */
    public void setSupport(boolean support) {
        this.support = support;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.inspireso.framework.context.BeanBuilder#build()
     */
    @Override
    public Product build() {
        return newInstance();
    }

    public static final Product newInstance() {
        return new Product();
    }

}
