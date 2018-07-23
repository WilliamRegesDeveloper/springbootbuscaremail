package br.com.advtec.event;

import java.io.InputStream;

import org.springframework.context.ApplicationEvent;

public class SalvarDowloadAnexoEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InputStream inputStream;

	public SalvarDowloadAnexoEvent(Object source, InputStream inputStream) {
		super(source);
		this.inputStream = inputStream;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}

}
