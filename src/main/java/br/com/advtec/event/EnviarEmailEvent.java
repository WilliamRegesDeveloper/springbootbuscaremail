package br.com.advtec.action;

import java.util.Arrays;

import org.springframework.context.ApplicationEvent;

import br.com.advtec.modelo.Mensagem;

public class EnviarEmailEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Mensagem mensagem;

	public EnviarEmailEvent(Object source) {
		super(source);
		
		mensagem = new Mensagem();
		mensagem.setMensagemDe("william@advtec.com.br");
		mensagem.setMensagemPara(Arrays.asList("william.reges1986@hotmail.com"));
		mensagem.setTitulo("Teste de Email");
		mensagem.setMensagem("Teste de envio de email com spring boot. \n \n Email enviado com exito.");
		mensagem.setConteudo("Este post é apenas para teste de rececimento de email testado por william"
				+ " \n usando Spring boot JavaMainSender e envio de anexos");
	}

	public Mensagem getMensagem() {
		return mensagem;
	}
}
