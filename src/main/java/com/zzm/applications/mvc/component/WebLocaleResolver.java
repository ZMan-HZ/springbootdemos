package com.zzm.applications.mvc.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * <b>Description</b>  WebResolver
 *
 * @Author Zhenzhen
 * @Since 2020-06-21 周日 12:15
 * @Info WebResolver
 */

public class WebLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getParameter("lan");
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(language)) {
            String[] lans = language.split("_");
            locale = new Locale(lans[0], lans[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
