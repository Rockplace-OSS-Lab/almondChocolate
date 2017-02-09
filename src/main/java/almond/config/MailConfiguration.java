package almond.config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;

@Configuration
@PropertySource("classpath:properties/mail.properties")
public class MailConfiguration {

	@Value("${mail.smtp.protocol}")
	private String protocol;
	@Value("${mail.smtp.host}")
	private String host;
	@Value("${mail.smtp.port}")
	private int port;
	@Value("${mail.smtp.auth}")
	private boolean auth;
	@Value("${mail.smtp.starttls.enable}")
	private boolean starttls;
	@Value("${mail.smtp.from}")
	private String from;
	@Value("${mail.smtp.username}")
	private String username;
	@Value("${mail.smtp.password}")
	private String password;
	
	@Value("${registration.template.file}")
	private String registrationTemplateFile;

	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.auth", auth);
		mailProperties.put("mail.smtp.starttls.enable", starttls);
		mailSender.setJavaMailProperties(mailProperties);
		mailSender.setHost(host);
		mailSender.setPort(port);
		mailSender.setProtocol(protocol);
		mailSender.setUsername(username);
		mailSender.setPassword(password);
		return mailSender;
	}

	@Bean(name = "registrationTemplate")
	public Template registrationTemplate() throws IOException {
		Handlebars handlebars = new Handlebars();
		return handlebars.compile(registrationTemplateFile);
	}
}
