package com.jana.restapi.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PatchApiTest {

	public static void main(String[] args) {
		
		String name = "FinApp%20Name";
//		%20 for empty spaces
		String status = "Patch%20UP";

		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest req= HttpRequest.newBuilder(URI.create("http://localhost:8000/api/health/patch/"+name+"?status="+status)).method("PATCH", HttpRequest.BodyPublishers.noBody()).header("Content-Type", "application/json").build();
		System.out.println(req.toString());

		try {
			HttpResponse<String> resp= client.send(req, HttpResponse.BodyHandlers.ofString());
			System.out.println(resp.body());

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
