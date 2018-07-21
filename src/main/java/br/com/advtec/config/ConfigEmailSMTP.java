package br.com.advtec.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import br.com.advtec.config.property.EmailSmtpProperties;

@Configuration
@Component
public class ConfigEmailSMTP {

	@Autowired
	private EmailSmtpProperties mailProperties;

	@Bean
	public JavaMailSender getJavaMailSender() {

		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost(mailProperties.getHost());
		sender.setPort(mailProperties.getPort());
		sender.setUsername(mailProperties.getUsername());
		sender.setPassword(mailProperties.getPassword());

		Properties properties = sender.getJavaMailProperties();
		properties.put("mail.transport.protocol", mailProperties.getProperties().get("mail.transport.protocol"));
		properties.put("mail.smtp.auth", mailProperties.getProperties().get("mail.smtp.auth"));
		properties.put("mail.smtp.starttls.enable", mailProperties.getProperties().get("mail.smtp.starttls.enable"));
		properties.put("mail.debug", "true");

		return sender;
	}
}
