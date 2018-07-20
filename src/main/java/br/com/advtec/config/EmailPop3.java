package br.com.advtec.config;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Configuration
@Component
@PropertySource("classpath:conf_pop3.properties")
public class EmailPop3 {

	@Autowired
	Environment envPropertie;

	@Bean
	public Session factorySession() {

		/** Propiedades de conexão pop3 */
		Properties prop = new Properties();		
		
//		prop.setProperty("mail.pop3.host", envPropertie.getProperty("mail.pop3.host"));
//		prop.setProperty("mail.pop3.port", envPropertie.getProperty("mail.pop3.port"));
//		prop.setProperty("mail.pop3.user", envPropertie.getProperty("mail.pop3.user"));
//		
//		prop.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//		prop.setProperty("mail.pop3.socketFactory.fallback", "true");
//		prop.setProperty("mail.pop3.socketFactory.port", "995");
		
		/** Authentica usuário */
		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(envPropertie.getProperty("mail.pop3.user"),
						envPropertie.getProperty("mail.pop3.password"));
			}
		};

		Session session = Session.getDefaultInstance(prop, authenticator);


		return session;

	}

}
