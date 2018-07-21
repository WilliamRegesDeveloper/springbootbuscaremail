package br.com.advtec.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("mail")
public class EmailPop3Properties {

	private final Pop3 pop3 = new Pop3();
	private final Store store = new Store();
	
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
	
}
