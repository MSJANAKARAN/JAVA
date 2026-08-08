package com.jana.restapi.httpurlconnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostApiTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		URL url = new URL("http://localhost:8000/api/health/post");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		con.setRequestMethod("POST");
		// setDoOutput default is false- if there is request payload, should be true to allow
		//similarly setDoInput default is true, setting false will restrict output[bytecode to response]
		con.setDoOutput(true);
		System.out.println(con.toString());

		String json = "{\n" + "\"name\": \"FinApp\"," + "\"status\": \"POST UP\"" + "}";

		con.addRequestProperty("Content-Type", "application/json");
		
		OutputStream input = con.getOutputStream();

		input.write(json.getBytes());
		
		input.flush();
		input.close();
		
		InputStream output;

		if (con.getResponseCode() >= 200 && con.getResponseCode() < 300) {
			output = con.getInputStream();
		} else {
			output = con.getErrorStream();
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(output));
		String line;

		StringBuilder resp = new StringBuilder();
		if ((line = br.readLine()) != null) {
			resp.append(line);
		}

		System.out.println(resp.toString());

		br.close();
	}

}
