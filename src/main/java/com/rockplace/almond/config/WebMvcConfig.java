package com.rockplace.almond.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import com.rockplace.almond.core.helpers.SpringSecurityHelper;

@Configuration
@ConditionalOnClass(HandlebarsViewResolver.class)
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Configuration
	@ConditionalOnClass(SpringSecurityHelper.class)
	static class SpringSecurityHelperAutoConfiguration {
		@Autowired
		private HandlebarsViewResolver handlebarsViewResolver;

		@Autowired
		private SpringSecurityHelper springSecurityHelper;

		@PostConstruct
		public void registerHelper() {
			handlebarsViewResolver.registerHelper(SpringSecurityHelper.NAME, springSecurityHelper);
		}
	}
}
