package br.com.advtec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.advtec.servicoemail.ServicoBuscarEmail;

@SpringBootApplication
public class EmailApplication implements ApplicationRunner {

	@Autowired
	private ServicoBuscarEmail servicoEmail;
	
	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		// TODO Auto-generated method stub
//		Mensagem mensagem = new Mensagem();
//		mensagem.setMensagemDe("william@advtec.com.br");
//		mensagem.setMensagemPara(Arrays.asList("william.reges1986@gmail.com"));
//		mensagem.setTitulo("Teste de Email");
//		mensagem.setMensagem("Teste de envio de email com spring boot. \n \n Email enviado com exito.");
//		mensagem.setConteudo("Este post é apenas para teste de rececimento de email testado por william"
//				+ " \n usando Spring boot JavaMainSender e envio de anexos");

//		servicoEmail.enviarEmail(mensagem);
		
		servicoEmail.buscaEmails();

	}
}
