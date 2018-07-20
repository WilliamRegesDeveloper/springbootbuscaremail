package br.com.advtec.servicoemail;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.advtec.modelo.Mensagem;

@Service
public class ServicoEnviaEmail {

	@Autowired
	private JavaMailSender sender;
	
	public void enviarEmail(Mensagem msg) {

		/** enviar email simples */

		// SimpleMailMessage message = new SimpleMailMessage();
		//
		// message.setFrom(msg.getMensagemDe());
		// message.setTo(msg.getMensagemPara().toArray(new
		// String[msg.getMensagemPara().size()]));
		// message.setSubject(msg.getTitulo());
		// message.setText(msg.getMensagem());
		//
		// sender.send(message);

		/** enviar email com anexo */
		try {

			MimeMessage mimeMessage = sender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

			Path path = Paths.get("C:", "Users", "willi", "Documents", "Apostilas Linguagem de Programacao", "java",
					"spring", "HttpCliente.pdf");

			messageHelper.setFrom(msg.getMensagemDe());
			messageHelper.setTo(msg.getMensagemPara().toArray(new String[msg.getMensagemPara().size()]));
			messageHelper.setSubject(msg.getTitulo());
			messageHelper.setText(msg.getConteudo());

			messageHelper.addAttachment("arquivo.pdf", new File(path.toAbsolutePath().toString()));

			sender.send(mimeMessage);

		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
