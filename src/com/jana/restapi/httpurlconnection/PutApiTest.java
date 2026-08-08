package com.jana.restapi.httpurlconnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PutApiTest {

	public static void main(String[] args) throws IOException {

		URL url = new URL("http://localhost:8000/api/health/update");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		con.setRequestMethod("PUT");
		con.setDoOutput(true);

		// will add new property
		con.addRequestProperty("Content-Type", "application/json");
		// will override property if already present
		con.setRequestProperty("Content-Type", "application/json");

		OutputStream input = con.getOutputStream();

		String json = "{\n" + "\"name\": \"FinApp\"," + "\"status\": \"PUT UP\"" + "}";

		input.write(json.getBytes());

		input.flush();

		input.close();

		System.out.println(con.toString());

		InputStream output;

		if (con.getResponseCode() >= 200 && con.getResponseCode() < 300) {
			output = con.getInputStream();
		} else {
			output = con.getErrorStream();
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(output));
		
		String line;
		
		StringBuilder resp = new StringBuilder();
		
		while((line=br.readLine())!=null) {
			resp.append(line);
		}
		
		System.out.println(resp.toString());
		
		br.close();

	}
//	FOR PATCH , doesnot support-> java.net.ProtocolException: Invalid HTTP method: PATCH

}
