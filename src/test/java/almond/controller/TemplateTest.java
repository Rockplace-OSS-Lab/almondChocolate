package almond.controller;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;

public class TemplateTest {
	private static final Logger log = LoggerFactory.getLogger(TemplateTest.class);
	
	@Test
	public void template() throws Exception {
		Handlebars handlebars = new Handlebars();
		Template template = handlebars.compile("/templates/email/email");
		log.debug("result : {}", template.apply("test"));
	}
}
