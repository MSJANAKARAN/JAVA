package com.jana.restapi.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DeleteApiTest {

	public static void main(String[] args) throws IOException, InterruptedException {

		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest req = HttpRequest.newBuilder(URI.create("http://localhost:8000/api/health/delete/FinApp")).DELETE().build();
		System.out.println(req.toString());
		HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
		
		System.out.println(resp.body());
	}

}
