package com.rockplace.almond.service;

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

@Component
@PropertySource("classpath:properties/mail.properties")
public class MailService {
	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${mail.smtp.from}")
	private String from;

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
