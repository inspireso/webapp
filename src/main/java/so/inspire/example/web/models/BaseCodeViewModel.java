/*
 * Copyright (c) 2014, Inspireso and/or its affiliates. All rights reserved.
 */

package so.inspire.example.web.models;

import java.util.List;

import com.google.common.collect.Lists;
import com.inspireso.framework.jpa.domain.AuditableObject;
import com.inspireso.framework.util.StringUtils;
import com.inspireso.framework.web.models.GenericViewModel;

/**
 * @author Inspireso Team
 * 
 */
public class BaseCodeViewModel<T extends AuditableObject> extends GenericViewModel<T> {

    public List<T> list = Lists.newArrayList();

    public T current;

    public boolean isActived() {
        return this.object.equals(this.current);
    }

    public String getCurrentCss() {
        return this.isActived() ? "active" : StringUtils.EMPTY;
    }

    private BaseCodeViewModel(T object) {
        super(object);
    }

    public static <F extends AuditableObject> BaseCodeViewModel<F> with(F object) {
        return new BaseCodeViewModel<F>(object);
    }

}
