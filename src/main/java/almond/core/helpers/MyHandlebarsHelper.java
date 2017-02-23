package almond.core.helpers;

import java.io.IOException;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.view.AbstractTemplateView;

import com.github.jknack.handlebars.Options;

import pl.allegro.tech.boot.autoconfigure.handlebars.HandlebarsHelper;

@HandlebarsHelper
public class MyHandlebarsHelper {
	private static final Logger log = LoggerFactory.getLogger(MyHandlebarsHelper.class);

	public CharSequence url(final String url, final Options options) throws IOException {
		log.debug("url : {}", url);
		RequestContext requestContext = (RequestContext) options
				.get(AbstractTemplateView.SPRING_MACRO_REQUEST_CONTEXT_ATTRIBUTE);
		Object[] params = options.params;
		return requestContext.getContextPath() + String.format(url, params);
	}

	protected Locale currentLocale() {
		return LocaleContextHolder.getLocale();
	}

	public CharSequence ifge(final int arg1, final int arg2, final Options options) throws IOException {
		if(arg1 >= arg2){
			return options.fn(this);
		}else{
			return options.inverse(this);
		}
	}
	
	public CharSequence ifgt(final int arg1, final int arg2, final Options options) throws IOException {
		if(arg1 > arg2){
			return options.fn(this);
		}else{
			return options.inverse(this);
		}
	}

	public CharSequence ifle(final int arg1, final int arg2, final Options options) throws IOException {
		if(arg1 <= arg2){
			return options.fn(this);
		}else{
			return options.inverse(this);
		}
	}
	
	public CharSequence iflt(final int arg1, final int arg2, final Options options) throws IOException {
		if(arg1 < arg2){
			return options.fn(this);
		}else{
			return options.inverse(this);
		}
	}
	
	public CharSequence ife(final int arg1, final int arg2, final Options options) throws IOException {
		if(arg1 == arg2){
			return options.fn(this);
		}else{
			return options.inverse(this);
		}
	}
}
