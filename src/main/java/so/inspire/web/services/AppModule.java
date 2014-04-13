/*
 * Copyright (c) 2014, Inspireso and/or its affiliates. All rights reserved.
 */

package so.inspire.web.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.InjectService;
import org.apache.tapestry5.ioc.annotations.SubModule;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.ioc.internal.services.ClasspathResourceSymbolProvider;
import org.apache.tapestry5.ioc.services.SymbolProvider;
import org.apache.tapestry5.services.javascript.JavaScriptStack;
import org.got5.tapestry5.jquery.JQuerySymbolConstants;
import org.slf4j.Logger;

import com.inspireso.framework.util.StringUtils;
import com.inspireso.framework.web.services.InspiresoModule;

@SubModule(InspiresoModule.class)
public class AppModule {
    public static void contributeJavaScriptStackSource(
            MappedConfiguration<String, JavaScriptStack> configuration) {

    }

    public static void bind(ServiceBinder binder) {

    }

    public static void contributeFactoryDefaults(MappedConfiguration<String, Object> configuration) {
        configuration.override(SymbolConstants.APPLICATION_VERSION, "1.0");
    }

    public static void contributeApplicationDefaults(
            MappedConfiguration<String, Object> configuration) {

        // configuration.override(SymbolConstants.PRODUCTION_MODE, true);
        // configuration.add(SymbolConstants.GZIP_COMPRESSION_ENABLED, true);
        // configuration.add(SymbolConstants.COMBINE_SCRIPTS, true);
        // configuration.add(SymbolConstants.COMPACT_JSON, true);
        // configuration.add(SymbolConstants.COMPRESS_WHITESPACE, true);
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "zh_CN");
        configuration.add(SymbolConstants.CHARSET, "UTF-8");

        // jquery module
        configuration.add(JQuerySymbolConstants.SUPPRESS_PROTOTYPE, true);
        configuration.add(JQuerySymbolConstants.JQUERY_CORE_PATH,
                "context:static/jquery/jquery-1.7.2.js");
        configuration.add(JQuerySymbolConstants.JQUERY_UI_DEFAULT_THEME,
                "context:static/jquery-ui/css/jquery-ui-1.9.2.custom.min.css");

    }

    public static void contributeSymbolSource(
            OrderedConfiguration<SymbolProvider> configuration,
            @InjectService("ClasspathResourceSymbolProvider") SymbolProvider provider) {
        configuration.add("InspiresoClasspathResource", provider,
                "after:SystemProperties", "after:ApplicationDefaults");

    }

    // make configuration from 'test.properties' on the classpath available as symbols
    public ClasspathResourceSymbolProvider buildClasspathResourceSymbolProvider(
            final Logger logger) {
        return new ClasspathResourceSymbolProvider("application.properties");

    }

    // 配置忽略某些路径不让Tapestry5处理，支持Servlet和自定义Filter
    public static void contributeIgnoredPathsFilter(Configuration<String> configuration,
            final Logger logger,
            @Symbol("app.ignored.paths") String paths) {

        if (StringUtils.isNotEmpty(paths)) {
            for (String path : paths.split(",")) {
                logger.info("###add ignored path [{}] success!", path);
                configuration.add(path);
            }
        }

    }

    // public RequestExceptionHandler decorateRequestExceptionHandler(
    // final Logger logger,
    // final ResponseRenderer renderer,
    // final ComponentSource componentSource,
    // @Symbol(SymbolConstants.PRODUCTION_MODE) boolean productionMode,
    // Object service) {
    //
    // if (!productionMode)
    // return null;
    //
    // return new RequestExceptionHandler() {
    // public void handleRequestException(Throwable exception) throws IOException {
    // logger.error("Unexpected runtime exception: " + exception.getMessage(), exception);
    //
    // ExceptionReporter InternalServerError = (ExceptionReporter)
    // componentSource.getPage("InternalServerError");
    //
    // InternalServerError.reportException(exception);
    //
    // renderer.renderPageMarkupResponse("InternalServerError");
    // }
    // };
    // }

}
