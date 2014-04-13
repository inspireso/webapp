/*
 * Copyright (c) 2014, Inspireso and/or its affiliates. All rights reserved.
 */

package so.inspire.web.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.annotations.SubModule;
import org.apache.tapestry5.services.LibraryMapping;

import so.inspire.example.web.services.ExampleModule;
import so.inspire.pay.web.services.PaymentModule;

/**
 * This module is automatically included as part of the Tapestry IoC Registry if
 * <em>tapestry.execution-modeId</em> includes <code>development</code>.
 */
@SubModule({
        ExampleModule.class,
        PaymentModule.class
})
public class DevelopmentModule {
    public static void contributeApplicationDefaults(
            MappedConfiguration<String, Object> configuration) {
        // The factory default is true but during the early stages of an application
        // overriding to false is a good idea. In addition, this is often overridden
        // on the command line as -Dtapestry.production-modeId=false
        configuration.add(SymbolConstants.PRODUCTION_MODE, false);

        // The application version page is incorprated into URLs for some
        // assets. Web browsers will cache assets because of the far future expires
        // header. If existing assets are changed, the version page should also
        // change, to force the browser to download new versions.
        configuration.add(SymbolConstants.APPLICATION_VERSION, "1.0-DEV");

    }

    public static void contributeComponentClassResolver(Configuration<LibraryMapping> configuration) {

    }

}
