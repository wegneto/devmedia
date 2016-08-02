package br.com.devmedia.wsclient.util;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class Factory {

	private static Client client;

	private Factory() {
	}

	public static Client getInstance() {
		if (client == null) {
			client = ClientBuilder.newClient();
		}
		
		return client;
	}

}
