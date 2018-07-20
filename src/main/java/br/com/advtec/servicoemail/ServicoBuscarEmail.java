package br.com.advtec.servicoemail;

import java.io.InputStream;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.advtec.config.EmailPop3;

@Service
public class ServicoBuscarEmail {

	@Autowired
	private EmailPop3 emailPop3;


	public void buscaEmails() {
		Session session = emailPop3.factorySession();

		try {
			Store store = session.getStore("pop3");
			store.connect("pop.advtec.com.br", 110, "rehau@advtec.com.br", "re123456");

			if (store.isConnected())
				System.out.println("Logado no Webmail");
			else
				System.out.println("Não conectado");

			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_ONLY);

			Message[] messages = folder.getMessages();

			for (int i = 0; i < 10; i++) {


				Object obj = messages[i].getContent();

				if (obj != null && obj instanceof Multipart) {

					Multipart part = (Multipart) obj;
					int count = part.getCount();

					for (int j = 0; j < count; j++) {
						BodyPart bodyPart = part.getBodyPart(j);

						if (bodyPart.getContentType().startsWith("application/xml")
								|| bodyPart.getContentType().startsWith("application/octet-stream")) {
							

							InputStream inputStream = bodyPart.getInputStream();
						
//							gravaXml.gravarXmlBanco(inputStream);
							
							
						}

					}

				}

			}

			folder.close(false);
			store.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
