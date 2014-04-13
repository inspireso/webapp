/*
 * Copyright (c) 2014, Inspireso and/or its affiliates. All rights reserved.
 */

package so.inspire.example.web.components;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.Parameter;

/**
 * @author XINEN
 * 
 */
public class Layout extends com.inspireso.framework.web.corelib.components.Layout {

    @Parameter
    private Block toolbar;

    /**
     * @return the toolbar
     */
    public Block getToolbar() {
        return toolbar;
    }

    /**
     * @param toolbar the toolbar to set
     */
    public void setToolbar(Block toolbar) {
        this.toolbar = toolbar;
    }

}
