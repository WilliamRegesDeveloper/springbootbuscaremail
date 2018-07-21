package br.com.advtec.config;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import br.com.advtec.config.property.EmailPop3Properties;

@Configuration
@Component
public class ConfigEmailPop3 {

	@Autowired
	private EmailPop3Properties pop3Propertie;

	@Bean
	public Session factorySession() {

		/** Propiedades de conexão pop3 */
		Properties prop = new Properties();

		/** Authentica usuário */
		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(pop3Propertie.getPop3().getUser(),
						pop3Propertie.getPop3().getPassword());
			}
		};

		Session session = Session.getDefaultInstance(prop, authenticator);

		return session;

	}

}
