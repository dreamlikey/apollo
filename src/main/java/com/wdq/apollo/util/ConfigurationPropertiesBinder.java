package com.wdq.apollo.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.*;
import org.springframework.boot.context.properties.bind.handler.IgnoreErrorsBindHandler;
import org.springframework.boot.context.properties.bind.handler.IgnoreTopLevelConverterNotFoundBindHandler;
import org.springframework.boot.context.properties.source.ConfigurationPropertySource;
import org.springframework.boot.context.properties.source.ConfigurationPropertySources;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.env.PropertySources;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 *
 */
@Component
public class ConfigurationPropertiesBinder implements ApplicationContextAware {

    private ConfigurableApplicationContext applicationContext;
    private PropertySources propertySources;
    private Binder binder;


    /**
     * 绑定source到spring应用上下文
     */
    public void bind(String configPrefix, Bindable<?> target) {
        BindHandler handler = new IgnoreTopLevelConverterNotFoundBindHandler();
        binder.bind(configPrefix, target, handler);
    }

    /**
     * 获取配置源
     */
    public Iterable<ConfigurationPropertySource> getConfigurationPropertySource() {
        return ConfigurationPropertySources.from(this.propertySources);
    }

    /**
     * 占位符解析器
     * 解析property的占位符
     */
    public PlaceholdersResolver getPlaceholdersResolver() {
        return new PropertySourcesPlaceholdersResolver(this.propertySources);
    }

    /**
     * 转换服务
     */
    public ConversionService getConversionService() {
        return this.applicationContext.getBeanFactory().getConversionService();
    }


    public Consumer<PropertyEditorRegistry> getPropertyEditorInitializer() {
        return this.applicationContext.getBeanFactory()::copyRegisteredEditorsTo;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (ConfigurableApplicationContext) applicationContext;
        this.propertySources = this.applicationContext.getEnvironment().getPropertySources();
        this.binder = new Binder(getConfigurationPropertySource(), getPlaceholdersResolver(),
                            getConversionService(), getPropertyEditorInitializer() );
    }
}
