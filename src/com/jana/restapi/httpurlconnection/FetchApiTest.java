package com.jana.restapi.httpurlconnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//HttpUrlConnection legacy rest api call suppressed from java 11
public class FetchApiTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		URL url = new URL("http://localhost:8000/api/health");

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		connection.setReadTimeout(5000);
		connection.setConnectTimeout(5000);
		
		System.out.println(connection.toString());

		InputStream output;
		if (connection.getResponseCode() >= 200 && connection.getResponseCode() < 300) {

			System.out.println("Response Code:" + connection.getResponseCode());

			output = connection.getInputStream();

		} else {

			System.out.println("Error:" + connection.getResponseCode());
			output = connection.getErrorStream();
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(output));

		String line;

		StringBuilder response = new StringBuilder();

		while ((line = br.readLine()) != null) {
			response.append(line);
		}

		System.out.println(response.toString());

		br.close();
	}
}
