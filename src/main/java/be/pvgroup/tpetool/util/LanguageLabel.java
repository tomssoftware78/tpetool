package be.pvgroup.tpetool.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class LanguageLabel {

    @Autowired
    private ReloadableResourceBundleMessageSource messageSource;

    public String getLabel(String key) {
        LocaleContext localeContext = LocaleContextHolder.getLocaleContext();

        return messageSource.getMessage(key, null, localeContext.getLocale());
    }

    
    @Bean
    public ReloadableResourceBundleMessageSource getReloadableResourceBundleMessageSource() {
        ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        reloadableResourceBundleMessageSource.setBasename("classpath:messages");
        reloadableResourceBundleMessageSource.setDefaultEncoding("UTF-8");
        return reloadableResourceBundleMessageSource;
    }

}
