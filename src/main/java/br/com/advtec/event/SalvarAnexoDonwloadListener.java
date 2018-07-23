package br.com.advtec.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SalvarAnexoDonwloadListener implements ApplicationListener<SalvarDowloadAnexoEvent> {

	@Override
	public void onApplicationEvent(SalvarDowloadAnexoEvent arg0) {

		if(arg0.getInputStream() != null){
			
			/**
			 * Implementação para persistencia dos anexos feitos do servido de
			 * download
			 */
			System.out.println("SalvarAnexoDonwloadListener.onApplicationEvent()");
		}
		
	}

}
