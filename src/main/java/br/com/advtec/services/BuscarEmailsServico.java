package br.com.advtec.services;

import java.io.IOException;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.advtec.config.ConfigEmailPop3;
import br.com.advtec.config.property.EmailPop3Properties;

@Service
public class BuscarEmailsServico {

	@Autowired
	private ConfigEmailPop3 emailPop3;
	
	@Autowired
	private EmailPop3Properties emailPop3Properties;

	public void buscarNotasDeEmailsXml() {
		Session session = emailPop3.factorySession();

		try {

			Store store = abreStorageDoEmail(session);

			Folder folder = abreInboxDoEmail(store);

			Message[] messages = folder.getMessages();

			desempactarAnexosParaSalvar(messages);

			folder.close(false);
			store.close();
		} catch (Exception e) {
		}
	}

	private Folder abreInboxDoEmail(Store store) throws MessagingException {
		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_ONLY);
		return folder;
	}

	private void desempactarAnexosParaSalvar(Message[] messages) throws IOException, MessagingException {

		for (int i = 0; i < 10; i++) {

			Object obj = messages[i].getContent();

			if (obj != null && obj instanceof Multipart) {

				Multipart part = (Multipart) obj;
				int count = part.getCount();

				for (int j = 0; j < count; j++) {
					BodyPart bodyPart = part.getBodyPart(j);

					if (bodyPart.getContentType().startsWith("application/xml")
							|| bodyPart.getContentType().startsWith("application/octet-stream")) {

						// InputStream inputStream = bodyPart.getInputStream();

						// gravaXml.gravarXmlBanco(inputStream);

					}

				}

			}

		}
	}

	private Store abreStorageDoEmail(Session session) throws NoSuchProviderException, MessagingException {

		Store store = session.getStore(emailPop3Properties.getStore().getProtocol());
		store.connect(emailPop3Properties.getPop3().getHost(), Integer.valueOf(emailPop3Properties.getPop3().getPort()),
					  emailPop3Properties.getPop3().getUser(), emailPop3Properties.getPop3().getPassword());

		if (store.isConnected())
			System.out.println("Logado no Webmail");
		else
			System.out.println("Não conectado");
		return store;
	}
}
