package com.mao.assignment.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Test {

	public static void main(String arg[]) {
		String urlString = "http://localhost:8080/khalibre-assignment-heng-mao/search?q=liferay-portal";
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			//conn.setRequestProperty("CONTENT-TYPE", "application/xml");
			conn.setRequestProperty("accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			StringBuffer responseString = new StringBuffer();
			String output;			
			while ((output = br.readLine()) != null) {
				responseString.append(output); 
			}

			System.out.println(responseString);

			conn.disconnect();

		} catch (MalformedURLException e) {
			System.out.print("MalformedURLException: URL" + e.getMessage());

		} catch (IOException e) {
			System.out.print("IOException: " + e.getMessage());
		}
	}
}
