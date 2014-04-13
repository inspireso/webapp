/*
 * Copyright (c) 2014, Inspireso and/or its affiliates. All rights reserved.
 */

package so.inspire.example.web.pages;

import org.apache.tapestry5.ValidationTracker;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;

import so.inspire.example.domain.Product;
import so.inspire.example.service.ProductService;
import so.inspire.example.web.models.BaseCodeViewModel;

import com.inspireso.framework.web.corelib.base.AbstractPage;
import com.inspireso.framework.web.util.ValidUtils;
import com.inspireso.framework.web.util.ValidUtils.ValidHelper;

/**
 * @author Inspireso Team
 * 
 */
public class Products extends AbstractPage<BaseCodeViewModel<Product>> {

    @InjectComponent
    private Zone mainZone;

    @Environmental
    private ValidationTracker tracker;

    @Inject
    private ProductService service;

    void onPrepareForSubmit() {
        super.model(this.newModel(Product.newInstance(), false));
    }

    void onValidateFromForm() {
        ValidHelper valid = ValidUtils
                .valid(this.messages, this.tracker);

        if (this.model().object.isNew()) {
            String code = this.model().object.getCode();
            Product car = this.service.findByCode(code);
            if (car != null) {
                valid.message(this.format("exists-message", code));

            }
        }

        if (!valid.hasError()) {
            try {
                service.saveOrUpdate(this.model().object);

            } catch (Exception e) {
                valid.message(this.string("carrier.saveorupdate.error-message"));
            }

        }
        this.clean();
        this.refresh();

    }

    void onFailureFromForm() {
        this.refresh();
    }

    void onUpdate(String id) {
        super.model(this.newModel(service.find(Product.class, id), true));
        this.refresh();
    }

    void onDelete(String id, long version) {
        try {
            service.delete(id, version);

        } catch (Exception e) {
            this.flash(this.string("saveorupdate.error-message"));
        }

        this.refresh();
    }

    public boolean isCurrentNotSupport() {
        return !this.model().current.isSupport();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.inspireso.framework.web.corelib.base.AbstractPage#newModel()
     */
    @Override
    protected BaseCodeViewModel<Product> newModel() {
        return newModel(Product.newInstance(), true);

    }

    protected BaseCodeViewModel<Product> newModel(Product object, boolean fetch) {
        BaseCodeViewModel<Product> model = BaseCodeViewModel.with(object);
        if (fetch) {
            model.list.addAll(service.findAll());
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
