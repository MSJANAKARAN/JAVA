package com.jana.restapi.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PutApiTest {

	public static void main(String[] args) {

		HttpClient client = HttpClient.newHttpClient();
		String url = "http://localhost:8000/api/health/update";
		String json = """
				{
					"name": "FinApp",
					"status": "PUT UP"
				}
				""";

		HttpRequest req = HttpRequest.newBuilder(URI.create(url)).PUT(HttpRequest.BodyPublishers.ofString(json))
				.header("Content-Type", "application/json").build();
		System.out.println(req.toString());

		try {
			HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
			System.out.println(resp.body());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
