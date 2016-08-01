package br.com.javamagazine.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Client {
	
	private static int HTTP_COD_SUCESSO = 200;

	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:8080/restfulExample/product");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "text/html");
			
			if(conn.getResponseCode() != HTTP_COD_SUCESSO) {
				throw new RuntimeException("HTTP error code: " + conn.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String saida;
			System.out.println("Output from Server.... \n" );
			
			while ((saida = br.readLine()) != null) {
				System.out.println(saida);
			}
			
			conn.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
