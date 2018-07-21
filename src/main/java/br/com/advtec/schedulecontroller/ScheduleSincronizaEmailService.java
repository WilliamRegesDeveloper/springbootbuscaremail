package br.com.advtec.schedulecontroller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.advtec.modelo.Mensagem;
import br.com.advtec.services.BuscarEmailsServico;
import br.com.advtec.services.EnviarEmailsServico;

@Service
@EnableScheduling
public class ScheduleSincronizaEmailService {
	
	@Autowired
	private BuscarEmailsServico servicoBuscaEmail;
	
	@Autowired
	private EnviarEmailsServico servicoEnviaEmail;

//	@Scheduled(cron = "* */1 * * * *")
//	public void buscarCaixaEmail() {
//		servicoBuscaEmail.buscarNotasDeEmailsXml();
//	}

	
	@Scheduled(fixedDelay= 1 * 60 * 1000)
	public void enviarEmail(){
		
		Mensagem mensagem = new Mensagem();
		mensagem.setMensagemDe("william@advtec.com.br");
		mensagem.setMensagemPara(Arrays.asList("william.reges1986@hotmail.com"));
		mensagem.setTitulo("Teste de Email");
		mensagem.setMensagem("Teste de envio de email com spring boot. \n \n Email enviado com exito.");
		mensagem.setConteudo("Este post é apenas para teste de rececimento de email testado por william"
				+ " \n usando Spring boot JavaMainSender e envio de anexos");

		servicoEnviaEmail.enviarEmailSimples(mensagem);
	}
}
