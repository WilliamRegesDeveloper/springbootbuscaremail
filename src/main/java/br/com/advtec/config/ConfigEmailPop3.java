package br.com.advtec.config;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.advtec.config.property.EmailPop3Properties;

@Configuration
public class ConfigEmailPop3 {

	@Autowired
	private EmailPop3Properties emailPop3Properties;

	@Bean
	public Session factorySession() {

		Properties prop = new Properties();

		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailPop3Properties.getPop3().getUser(),
						emailPop3Properties.getPop3().getPassword());
			}
		};

		Session session = Session.getDefaultInstance(prop, authenticator);

		return session;

	}

	@Bean
	@Autowired
	public Folder abreInboxDoEmail(Session session) {

		Folder folder = null;
		try {
			
			Store store = session.getStore(emailPop3Properties.getStore().getProtocol());
			store.connect(emailPop3Properties.getPop3().getHost(),
					Integer.valueOf(emailPop3Properties.getPop3().getPort()), emailPop3Properties.getPop3().getUser(),
					emailPop3Properties.getPop3().getPassword());

			folder = store.getFolder("INBOX");
			folder.open(Folder.READ_ONLY);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return folder;
	}
}
