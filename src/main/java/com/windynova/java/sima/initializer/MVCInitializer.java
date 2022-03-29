package com.windynova.java.sima.initializer;

import com.sun.org.apache.xerces.internal.parsers.SecurityConfiguration;
import com.windynova.java.sima.config.MVCConfiguration;
import com.windynova.java.sima.config.RootConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author
 * @date 2022/3/29
 * @apinote
 */
public class MVCInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfiguration.class, SecurityConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MVCConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
