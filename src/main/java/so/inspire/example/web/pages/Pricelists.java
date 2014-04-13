/*
 * Copyright (c) 2014, Inspireso and/or its affiliates. All rights reserved.
 */

package so.inspire.example.web.pages;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.tapestry5.ValidationTracker;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;

import so.inspire.example.domain.Pricelist;
import so.inspire.example.domain.Product;
import so.inspire.example.service.PricelistService;
import so.inspire.example.service.ProductService;
import so.inspire.example.web.models.BaseCodeViewModel;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.inspireso.framework.util.StringUtils;
import com.inspireso.framework.web.corelib.base.AbstractPage;
import com.inspireso.framework.web.util.ValidUtils;
import com.inspireso.framework.web.util.ValidUtils.ValidHelper;

/**
 * @author Inspireso Team
 * 
 */
public class Pricelists extends AbstractPage<BaseCodeViewModel<Pricelist>> {

    @InjectComponent
    private Zone mainZone;

    @Environmental
    private ValidationTracker tracker;

    @Inject
    private PricelistService price;

    @Inject
    private ProductService carrier;

    void onPrepareForSubmit() {
        super.model(this.newModel(Pricelist.newInstance(), false));
    }

    void onValidateFromForm() {
        ValidHelper valid = ValidUtils
                .valid(this.messages, this.tracker);

        if (this.model().object.isNew()) {
            String code = this.model().object.getProductCode();
            List<Pricelist> list = this.price.findByProduct(code);
            if (list != null && list.size() > 0) {
                valid.message(this.format("pricelist.exists-message", code));

            }
        }
        Pricelist object = this.model().object;
        if (StringUtils.isNotEmpty(object.getProductCode())) {
            object.setProductName(carrier.findByCode(object.getProductCode()).getName());
        }

        if (!valid.hasError()) {
            try {
                price.saveOrUpdate(object);

            } catch (Exception e) {
                valid.message(this.string("pricelist.saveorupdate.error-message="));

            }

        }
        this.clean();
        this.refresh();

    }

    void onFailureFromForm() {
        this.refresh();
    }

    void onUpdate(String id) {
        super.model(this.newModel(price.find(id), true));
        this.refresh();
    }

    void onDelete(String id, long version) {
        try {
            price.delete(id, version);

        } catch (Exception e) {
            this.flash(this.string("pricelist.saveorupdate.error-message"));

        }

        this.refresh();
    }

    public Map<String, String> getProductMap() {
        List<Product> carrieres = carrier.findAll();
        Map<String, String> map = Maps.newHashMap();
        for (Product c : carrieres) {
            map.put(c.getCode(), c.getName());
        }
        return map;
    }

    public Map<String, String> getCurrencyMap() {
        return this.map("pricelist.currency-map");
    }

    public String[] getFreightArray() {
        return this.array("pricelist.freight-array");
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.inspireso.framework.web.corelib.base.AbstractPage#newModel()
     */
    @Override
    protected BaseCodeViewModel<Pricelist> newModel() {
        return newModel(Pricelist.newInstance(), true);

    }

    protected BaseCodeViewModel<Pricelist> newModel(Pricelist object, boolean fetch) {
        BaseCodeViewModel<Pricelist> model = BaseCodeViewModel.with(object);
        if (object.isNew()) {
            Map<String, String> map = getCurrencyMap();
            if (map.size() > 0) {
                object.setCurrency(Iterables.getFirst(map.keySet(), null));
            }

            String[] freight = getFreightArray();
            if (freight.length > 0) {
                object.setName(freight[0]);
            }
            object.setPrice(new BigDecimal(0).setScale(2));
        }
        if (fetch) {
            model.list.addAll(price.findAll());
        }
        return model;

    }

    private boolean refresh() {
        if (this.isAjax()) {
            this.addRender(this.mainZone);
        }
        return true;
    }

}
