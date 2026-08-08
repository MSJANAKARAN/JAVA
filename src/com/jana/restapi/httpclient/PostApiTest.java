package com.jana.restapi.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostApiTest {

	public static void main(String[] args) {

		HttpClient client = HttpClient.newHttpClient();
		String json="""
				{
					"name": "FinApp",
					"status": "POST UP"
				}
				""";
		
		HttpRequest req = HttpRequest.newBuilder(URI.create("http://localhost:8000/api/health/post"))
				.POST(HttpRequest.BodyPublishers.ofString(json)).setHeader("Content-Type", "application/json").build();
		System.out.println(req.toString());
		try {
			HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
			System.out.println(resp.body());

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
