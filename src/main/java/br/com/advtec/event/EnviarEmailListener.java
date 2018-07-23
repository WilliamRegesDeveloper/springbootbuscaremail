package br.com.advtec.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import br.com.advtec.services.EnviarEmailsServico;

@Component
public class EnviarEmailListener implements ApplicationListener<EnviarEmailEvent> {

	@Autowired
	private EnviarEmailsServico servicoEnviaEmail;
	
	@Override
	public void onApplicationEvent(EnviarEmailEvent arg0) {
		
		servicoEnviaEmail.enviarEmailSimples(arg0.getMensagem());
	}

}
