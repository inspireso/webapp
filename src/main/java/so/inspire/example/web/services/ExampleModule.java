/*
 * Copyright (c) 2014, Inspireso and/or its affiliates. All rights reserved.
 */

package so.inspire.example.web.services;

import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.services.LibraryMapping;
import org.apache.tapestry5.services.javascript.JavaScriptStack;

/**
 * @author Inspireso Team
 * 
 */
public class ExampleModule {
    public static void contributeJavaScriptStackSource(
            MappedConfiguration<String, JavaScriptStack> configuration) {

    }

    public static void bind(ServiceBinder binder) {

    }

    public static void contributeFactoryDefaults(MappedConfiguration<String, Object> configuration) {

    }

    public static void contributeApplicationDefaults(
            MappedConfiguration<String, Object> configuration) {

    }

    public static void contributeComponentClassResolver(Configuration<LibraryMapping> configuration) {
        configuration.add(new LibraryMapping("example", "so.inspire.example.web"));
    }
}
