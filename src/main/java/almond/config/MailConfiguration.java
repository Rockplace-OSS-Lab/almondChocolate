package almond.config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;

@Configuration
@PropertySource("classpath:properties/mail.properties")
public class MailConfiguration {
	@Autowired
	private Environment env;

	@Value("${registration.template.file}")
	private String registrationTemplateFile;

	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.auth", env.getProperty("mail.smtp.auth"));
		mailProperties.put("mail.smtp.starttls.enable", env.getProperty("mail.smtp.starttls.enable"));
		mailSender.setJavaMailProperties(mailProperties);
		mailSender.setHost(env.getProperty("mail.smtp.host"));
		mailSender.setPort(Integer.parseInt(env.getProperty("mail.smtp.port")));
		mailSender.setProtocol(env.getProperty("mail.smtp.protocol"));
		mailSender.setUsername(env.getProperty("mail.smtp.username"));
		mailSender.setPassword(env.getProperty("mail.smtp.password"));
		return mailSender;
	}

	@Bean(name = "registrationTemplate")
	public Template registrationTemplate() throws IOException {
		Handlebars handlebars = new Handlebars();
		return handlebars.compile(registrationTemplateFile);
	}
}
