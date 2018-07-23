package br.com.advtec.services;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import br.com.advtec.event.EnviarEmailEvent;
import br.com.advtec.event.SalvarDowloadAnexoEvent;

@Service
public class BuscarAnexosDeEmailServico {

	@Autowired
	private Folder folder;

	@Autowired
	private ApplicationEventPublisher publish;

	public void buscarEmailsComNotasAnexasXml() {

		try {

			Message[] messages = folder.getMessages();

			desempactarAnexosParaSalvar(messages);

			Store store = folder.getStore();
			folder.close(false);
			store.close();

			EnviarEmailEvent email = new EnviarEmailEvent(this);
			publish.publishEvent(email);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void desempactarAnexosParaSalvar(Message[] messages) throws IOException, MessagingException {

		for (int i = 0; i < 100; i++) {

			Object obj = messages[i].getContent();

			if (obj != null && obj instanceof Multipart) {

				Multipart part = (Multipart) obj;
				int count = part.getCount();

				for (int j = 0; j < count; j++) {
					BodyPart bodyPart = part.getBodyPart(j);

					if (bodyPart.getContentType().startsWith("application/xml")
							|| bodyPart.getContentType().startsWith("application/octet-stream")) {

						InputStream inputStream = bodyPart.getInputStream();

						publish.publishEvent(new SalvarDowloadAnexoEvent(this, inputStream));

					}

				}

			}

		}
	}

}
