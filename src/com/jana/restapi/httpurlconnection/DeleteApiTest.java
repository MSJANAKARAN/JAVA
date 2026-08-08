package com.jana.restapi.httpurlconnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DeleteApiTest {

	public static void main(String[] args) throws IOException {

		URL url = new URL("http://localhost:8000/api/health/delete/FinApp");
		
		HttpURLConnection con= (HttpURLConnection) url.openConnection();
		
		con.addRequestProperty("Content-Type", "application/json");
		
		con.setRequestMethod("DELETE");
				
		InputStream output;
		System.out.println(con.toString());

		if(con.getResponseCode()>=200 && con.getResponseCode()<300) {
			output = con.getInputStream();
		}else {
			output = con.getErrorStream();
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(output));
		String line;
		
		StringBuilder resp = new StringBuilder();
		
		while((line=br.readLine())!=null) {
			resp.append(line);
		}
		
		System.out.println(resp);
	}

}
