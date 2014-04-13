/*
 * Copyright (c) 2014, Inspireso and/or its affiliates. All rights reserved.
 */

package so.inspire.example.domain.base;

import javax.persistence.MappedSuperclass;

import com.inspireso.framework.domain.BusinessObject;

/**
 * @author Inspireso Team
 * 
 */
@MappedSuperclass
public abstract class AbstractCode extends BusinessObject {

    private static final long serialVersionUID = 1L;
    private String code;
    private String fullName;

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
