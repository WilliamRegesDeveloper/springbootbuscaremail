package br.com.advtec.modelo;

import java.util.List;

public class Mensagem {

	private String mensagemDe;
	private List<String> mensagemPara;
	private String titulo;
	private String mensagem;
	private String conteudo;

	public String getMensagemDe() {
		return mensagemDe;
	}

	public void setMensagemDe(String mensagemDe) {
		this.mensagemDe = mensagemDe;
	}

	public List<String> getMensagemPara() {
		return mensagemPara;
	}

	public void setMensagemPara(List<String> mensagemPara) {
		this.mensagemPara = mensagemPara;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getConteudo() {
		return conteudo;
	}
	
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

}
