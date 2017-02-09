package almond.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import com.github.jknack.handlebars.Template;

import almond.domain.User;

@Component
@PropertySource("classpath:properties/mail.properties")
public class MailService {
	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${mail.smtp.from}")
	private String from;
	
	@Value("${almond.base.url}")
	private String baseUrl;
	
	@Resource(name = "registrationTemplate")
	private Template registrationTemplate;
	
	public boolean sendRegistrationMail(User user) {
		String contents;
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("user", user);
			params.put("baseUrl", baseUrl);
			contents = registrationTemplate.apply(params);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return sendMail(user.getEmail(), "승인요청메일", contents);
	}
	
	public boolean sendMail(String to, String subject, String content) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
				mimeMessage.setFrom(new InternetAddress(from));
				mimeMessage.setSubject(subject);
				mimeMessage.setText(content, "utf-8", "html");
			}
		};

		try {
			javaMailSender.send(preparator);

			return true;
		} catch (MailException me) {
			me.printStackTrace();
			return false;
		}
	}
}
