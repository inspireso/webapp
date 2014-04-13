/*
 * Copyright (c) 2014, Inspireso and/or its affiliates. All rights reserved.
 */

package so.inspire.example.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.inspireso.framework.context.BeanBuilder;
import com.inspireso.framework.domain.BusinessObject;

/**
 * @author Inspireso Team
 * 
 */
@Entity
@Table(name = "exp_pricelist")
public class Pricelist extends BusinessObject implements BeanBuilder<Pricelist> {

    private static final long serialVersionUID = 1L;

    private BigDecimal price;

    private String currency;

    @OrderBy
    private int orderBy;

    @Column(name = "exp_product_code")
    private String productCode;

    @Column(name = "exp_product_name")
    private String productName;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

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

    /*
     * (non-Javadoc)
     * 
     * @see com.inspireso.framework.context.BeanBuilder#build()
     */
    @Override
    public Pricelist build() {
        return newInstance();
    }

    public static final Pricelist newInstance() {
        return new Pricelist();
    }

}
