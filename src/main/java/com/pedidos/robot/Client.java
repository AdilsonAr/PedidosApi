package com.pedidos.robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

public class Client {
	 String endpoint="http://localhost:8080/";
     String consulta="pedido/readall";
	 String url=endpoint+consulta;
	
	HttpClientBuilder builder=HttpClients.custom();
	HttpClient client=builder.build();
	
	HttpGet rq=new HttpGet(url);
	
	
	public void consultar() throws ClientProtocolException, IOException {
		rq.addHeader("Content_Type","application/json");
		rq.addHeader("Accept","application/json");
		
		HttpResponse response=client.execute(rq);
		
		System.out.println("HttpResponse: "+response.getStatusLine().getStatusCode());
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuilder stb=new StringBuilder();
		String line="";
		while((line=bf.readLine()) !=null){
			stb.append(line);
		}
		System.out.println(stb.toString());
	}
	
}
