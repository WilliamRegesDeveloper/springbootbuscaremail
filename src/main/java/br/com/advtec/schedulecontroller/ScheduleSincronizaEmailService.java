package br.com.advtec.schedulecontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.advtec.services.BuscarEmailsServico;

@Service
@EnableScheduling
public class ScheduleSincronizaEmailService {
	
	@Autowired
	private BuscarEmailsServico servicoBuscaEmail;


	@Scheduled(fixedDelay= 1 * 60 * 1000)
	public void buscarCaixaEmail() {
		servicoBuscaEmail.buscarNotasDeEmailsXml();
	}

}
