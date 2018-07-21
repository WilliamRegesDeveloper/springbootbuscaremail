package br.com.advtec.services;

import java.io.File;
import java.nio.file.Path;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.advtec.modelo.Mensagem;

@Service
public class EnviarEmailsServico {

	@Autowired
	private JavaMailSender sender;
	
	public void enviarEmailSimples(Mensagem msg) {

		/** enviar email simples */

		 SimpleMailMessage message = new SimpleMailMessage();
		
		 message.setFrom(msg.getMensagemDe());
		 message.setTo(msg.getMensagemPara().toArray(new
		 String[msg.getMensagemPara().size()]));
		 message.setSubject(msg.getTitulo());
		 message.setText(msg.getMensagem());
		
		 sender.send(message);

	}
	
	public void enviarEmailComAnexo(Mensagem msg, Path path){
		/** enviar email com anexo */
		try {

			MimeMessage mimeMessage = sender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

//			Path path = Paths.get("C:", "Users", "willi", "Documents", "Apostilas Linguagem de Programacao", "java",
//					"spring", "HttpCliente.pdf");

			messageHelper.setFrom(msg.getMensagemDe());
			messageHelper.setTo(msg.getMensagemPara().toArray(new String[msg.getMensagemPara().size()]));
			messageHelper.setSubject(msg.getTitulo());
			messageHelper.setText(msg.getConteudo());

			messageHelper.addAttachment("arquivo.pdf", new File(path.toAbsolutePath().toString()));

			sender.send(mimeMessage);

		} catch (MessagingException e1) {
			e1.printStackTrace();
		}
	}
}
