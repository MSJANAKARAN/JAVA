package com.jana.restapi.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.nio.charset.StandardCharsets;

//HttpClient introduced in java 11 replacing HttpUrlConnection
public class FetchApiTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		HttpClient client =  HttpClient.newHttpClient();
		HttpRequest req = HttpRequest.newBuilder(URI.create("http://localhost:8000/api/health")).GET().build();

		HttpResponse <String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
		
		System.out.println(resp.toString());
		System.out.println(resp.body());
		System.out.println("================================================================================");

		HttpRequest req2 = HttpRequest.newBuilder(URI.create("http://localhost:8000/api/db-health")).GET().build();
		
		HttpResponse <String> resp2 = client.send(req2, HttpResponse.BodyHandlers.ofString());

		System.out.println(resp2.toString());
		System.out.println(resp2.body());

	}
//	BodyPublisher → Sends the request body
//	BodyHandlers → Used when receiving the HTTP response (client side, high-level API).
//	BodySubscribers → Low-level implementation used inside BodyHandlers to process the incoming response bytes.

//	Request (Client → Server)
//
//	BodyPublisher
//	      │
//	      ▼
//	HTTP Request
//	      │
//	      ▼
//		Server
//		   │
//		   ▼
//		HTTP Response
//		   │
//		   ▼
//		BodySubscriber  ← Reads bytes from network
//		   │
//		   ▼
//		BodyHandler     ← Returns final object
//		   │
//		   ▼
//		Your Java Code

}
