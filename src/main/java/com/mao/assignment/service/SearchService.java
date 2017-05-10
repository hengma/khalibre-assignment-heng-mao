package com.mao.assignment.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

import com.google.gson.Gson;
import com.mao.assignment.model.GithubXML;
import com.mao.assignment.model.Items;
import com.mao.assignment.model.GithubJSON;
import com.mao.assignment.util.JaxbTransformer;

@Path("/search")
public class SearchService {

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public String doGetAsXmlOrJson(
			@Context HttpHeaders headers, 
			@QueryParam("q") String q,
			@DefaultValue("star") @QueryParam("sort") String sort,
			@DefaultValue("desc") @QueryParam("order") String order) {
	
		Gson g = new Gson();
		GithubJSON githubJSON = g.fromJson(getResponse(q, sort, order), GithubJSON.class);

		if(headers.getRequestHeaders().get("content-type") != null && MediaType.APPLICATION_XML.equals(headers.getRequestHeaders().get("content-type").get(0))) {
			GithubXML githubXml = new GithubXML();
			githubXml.setTotalCount(githubJSON.getTotal_count());
			Items items = new Items();
			items.setItems(githubJSON.getItems());
			githubXml.setItems(items);
			try {
				return JaxbTransformer.INSTANCE.marshall(githubXml);
			} catch (JAXBException e) {
				throw new WebApplicationException(Response
						.status(HttpURLConnection.HTTP_BAD_REQUEST)
						.entity("JAXBException: " + e.getMessage()).build());
			}
		}
		
		return g.toJson(githubJSON);		
	}
	
	
	/**
	 * 
	 * @param q The search keywords, as well as any qualifiers
	 * @param sort The sort field. One of stars, forks, or updated. Default: stars.
	 * @param order The sort order if sort parameter is provided. One of asc or desc. Default: desc.
	 * @return response string
	 */
	public String getResponse(String q, String sort, String order) {

		//Parameter q is mandatory
		if (q == null) {
			throw new WebApplicationException(Response
					.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity("q parameter is mandatory").build());
		}

		String param = "q=" + q + "&sort=" + sort + "&order=" + order;
		String urlString = "https://api.github.com/search/repositories?" + param;
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new WebApplicationException(Response
						.status(HttpURLConnection.HTTP_BAD_REQUEST)
						.entity("Failed : HTTP error code : "
								+ conn.getResponseCode()).build());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			StringBuffer responseString = new StringBuffer();
			String output;
			while ((output = br.readLine()) != null) {
				responseString.append(output);
			}

			conn.disconnect();

			return responseString.toString();

		} catch (MalformedURLException e) {
			throw new WebApplicationException(Response
					.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity("URL " + urlString
							+ " is not correct!, MalformedURLException: "
							+ e.getMessage()).build());

		} catch (IOException e) {
			throw new WebApplicationException(Response
					.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity("IOException: " + e.getMessage()).build());
		}

	}
	
}