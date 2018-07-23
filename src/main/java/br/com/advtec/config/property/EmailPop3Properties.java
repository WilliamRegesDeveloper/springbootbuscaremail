package br.com.advtec.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("mail")
public class EmailPop3Properties {

	private Pop3 pop3;
	private Store store;
	
	public Pop3 getPop3() {
		return pop3;
	}
	
	public Store getStore() {
		return store;
	}
	
	public static class Pop3 {
		private String host;
		private String port;
		private String user;
		private String password;
		
		private SocketFactory socketFactory;

		public String getHost() {
			return host;
		}

		public void setHost(String host) {
			this.host = host;
		}

		public String getPort() {
			return port;
		}

		public void setPort(String port) {
			this.port = port;
		}

		public String getUser() {
			return user;
		}
		
		public void setUser(String user) {
			this.user = user;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		public SocketFactory getSocketFactory() {
			return socketFactory;
		}
		
		public void setSocketFactory(SocketFactory socketFactory) {
			this.socketFactory = socketFactory;
		}

	}

	public static class Store {
		private String protocol;

		public String getProtocol() {
			return protocol;
		}

		public void setProtocol(String protocol) {
			this.protocol = protocol;
		}
	}
	
	public static class SocketFactory {

		private String classe;
		private String fallback;
		private String port;

		public String getClasse() {
			return classe;
		}

		public void setClasse(String classe) {
			this.classe = classe;
		}

		public String getFallback() {
			return fallback;
		}

		public void setFallback(String fallback) {
			this.fallback = fallback;
		}

		public String getPort() {
			return port;
		}

		public void setPort(String port) {
			this.port = port;
		}

	}
	
}
