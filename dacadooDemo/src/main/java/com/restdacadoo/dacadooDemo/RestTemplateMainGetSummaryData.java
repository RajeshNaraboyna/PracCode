package com.restdacadoo.dacadooDemo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class RestTemplateMainGetSummaryData {

	public static void main(String[] args) throws Exception {
		// System.out.println(getDacadoooRespo());
		sendPost();
	}

	public static String getDacadoooRespo() {
		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		// Connect timeout
		clientHttpRequestFactory.setConnectTimeout(20_000);
		// Read timeout
		clientHttpRequestFactory.setReadTimeout(20_000);

		// HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new
		// HttpComponentsClientHttpRequestFactory();
		// clientHttpRequestFactory.setConnectionRequestTimeout(10000);
		// clientHttpRequestFactory.setConnectTimeout(10000);
		// clientHttpRequestFactory.setReadTimeout(10000);
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		// restTemplate.
		String result = null;
		try {
			// https://models.dacadoo.com/score/1
			HttpEntity<String> entity = new HttpEntity<>(getRequestPayloadMin(), createHttpHeaders());
			// ResponseEntity<String> response =
			// restTemplate.exchange("https://models.dacadoo.com/score/1",
			// HttpMethod.POST, entity, String.class);
			// ClientHttpRequestFactory requestFactory =
			// getClientHttpRequestFactory();
			// RestTemplate restTemplate = new RestTemplate(requestFactory);
			//  
			// HttpEntity<Foo> request = new HttpEntity<>(new Foo("bar"));
			String foo = restTemplate.postForObject("https://models.dacadoo.com/score/1", entity, String.class);
			// assertThat(foo, notNullValue());
			// assertThat(foo.getName(), is("bar"));
			// ResponseEntity<String> response =
			// restTemplate.exchange("http://localhost:8080/dacadoo/gethealth",HttpMethod.GET,
			// entity, String.class);
			// System.out.println("Result - status (" + response.getStatusCode()
			// + ") has body: " + response.hasBody());
			// System.out.println("Response Body : " + response.getBody());
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static String getRequestPayloadMin() {
		return "{\"mhm\":{\"age\":44,\"sex\":1,\"hgt\":177.8,\"wgt\":82}}";
	}

	private static String getRequestPayload() {
		return "{\"mhm\":{\"age\":44,\"sex\":1,\"hgt\":177.8,\"wgt\":82},\"smk\":{\"now\":1,\"evr\":0},\"slp\":{\"bed\":[4.0,null,null,7.5,8.0],\"slp\":[5.0,null,null,5.0,7.9],\"awk\":[4,null,null,4,1]},\"nut\":{\"nqs\":[0.5,0.5,0.3,0.5,null,0,0,0,0.3,0.3,0]},\"qlm\":{\"q01\":0.7,\"q02\":0.6,\"q07\":0.7,\"q20\":0.7}}";
	}

	private static HttpHeaders createHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		// headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("x-dacadoo-key", "DoeACT0k2lDl8fRmLvH6EwgDu7Vo8hwWVUhw8dSH");
		// headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("host", "models.dacadoo.com");
		headers.add("content-type", "application/json");
		return headers;
	}

	private static void sendPost() throws Exception {

		String url = "https://models.dacadoo.com/score/1";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("x-dacadoo-key", "DoeACT0k2lDl8fRmLvH6EwgDu7Vo8hwWVUhw8dSH");
		con.setRequestProperty("host", "models.dacadoo.com");
		con.setRequestProperty("content-type", "application/json");

		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(getRequestPayload());
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

	}
}
