package com.main;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TimeZone;

import javax.net.ssl.SSLContext;
import javax.security.cert.X509Certificate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class RestTemplateMain {

	public static void main(String[] args) {
//		System.out.println(getDacadoooRespo());
		System.out.println(getDacadoooRespo1(""));
	}

	public static DacadooResponseModel getDacadoooRespo1(String request) {
		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress("www-proxy.us.oracle.com", 80));
//		clientHttpRequestFactory.setProxy(proxy);
		clientHttpRequestFactory.setConnectTimeout(20_000);
		clientHttpRequestFactory.setReadTimeout(20_000);
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		DacadooResponseModel dacadooResponseModel =null;
		try {
			org.springframework.http.HttpEntity<String> entity = new org.springframework.http.HttpEntity<>("", createHttpHeaders());
			 ResponseEntity<String> response = restTemplate.exchange(/*"https://models.dacadoo.com/score/1"*/"http://den02ohv.us.oracle.com:8080/score/1" , HttpMethod.GET, entity, String.class);
			System.out.println("Result - status (" + response.getStatusCode() + ") has body: " + response.hasBody());
			System.out.println("Response Body : " + response.getBody());
			  dacadooResponseModel = (DacadooResponseModel) buildObjectFromJsonString(
					response.getBody(), DacadooResponseModel.class, null);
			System.out.println(dacadooResponseModel);
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return dacadooResponseModel;
	}
	
	public static DacadooResponseModel getDacadoooRespo() {
		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress("www-proxy.us.oracle.com", 80));
		clientHttpRequestFactory.setProxy(proxy);
		clientHttpRequestFactory.setConnectTimeout(20_000);
		clientHttpRequestFactory.setReadTimeout(20_000);
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		DacadooResponseModel dacadooResponseModel =null;
		try {
			// https://models.dacadoo.com/score/1
			HttpEntity<String> entity = new HttpEntity<>(getRequestPayloadMin(), createHttpHeaders());
			 ResponseEntity<String> response = restTemplate.exchange("https://models.dacadoo.com/score/1", HttpMethod.POST, entity, String.class);
//			ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/dacadoo/gethealth",	HttpMethod.GET, entity, String.class);
			System.out.println("Result - status (" + response.getStatusCode() + ") has body: " + response.hasBody());
			System.out.println("Response Body : " + response.getBody());
			  dacadooResponseModel = (DacadooResponseModel) buildObjectFromJsonString(
					response.getBody(), DacadooResponseModel.class, null);
			System.out.println(dacadooResponseModel);
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return dacadooResponseModel;
	}

	@SuppressWarnings({ "unchecked" })
	protected static Object buildObjectFromJsonString(final String jsonString, Class objectClass,
			final Map<Class, Class> abstractTypeResolverMap) {

		System.out.println("Entering buildObjectFromJsonString method of BaseServiceDelegate");
		Object object = null;
		try {
			String safeJsonString = jsonString;
			ObjectMapper objectMapper = getObjectMapper(abstractTypeResolverMap);
			object = objectMapper.readValue(safeJsonString, objectClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	@SuppressWarnings({ "unchecked", "serial" })
	protected static ObjectMapper getObjectMapper(final Map<Class, Class> abstractTypeResolverMap) {

		ObjectMapper objectMapper = new ObjectMapper();
		prepareMapper(objectMapper);
		objectMapper.registerModule(new SimpleModule() {

			@Override
			public void setupModule(SetupContext context) {

				if (null != abstractTypeResolverMap) {

					for (Class typeResolverInterface : abstractTypeResolverMap.keySet()) {
						Class typeResolverImpl = abstractTypeResolverMap.get(typeResolverInterface);
						context.addAbstractTypeResolver(
								new SimpleAbstractTypeResolver().addMapping(typeResolverInterface, typeResolverImpl));
					}
				}
			}
		});

		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
		objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
		return objectMapper;
	}

	public static void prepareMapper(ObjectMapper mapper) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		mapper.setDateFormat(df);
		mapper.setTimeZone(TimeZone.getDefault());
	}

	private static String getRequestPayloadMin() {
		return "{\"mhm\":{\"age\":44,\"sex\":1,\"hgt\":177.8,\"wgt\":82}}";
	}

	private static String getRequestPayload() {
		return "{\"mhm\":{\"age\":44,\"sex\":1,\"hgt\":177.8,\"wgt\":82},\"smk\":{\"now\":1,\"evr\":0},\"slp\":{\"bed\":[4.0,null,null,7.5,8.0],\"slp\":[5.0,null,null,5.0,7.9],\"awk\":[4,null,null,4,1]},\"nut\":{\"nqs\":[0.5,0.5,0.3,0.5,null,0,0,0,0.3,0.3,0]},\"qlm\":{\"q01\":0.7,\"q02\":0.6,\"q07\":0.7,\"q20\":0.7}}";
	}

	private static HttpHeaders createHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("x-dacadoo-key", "DoeACT0k2lDl8fRmLvH6EwgDu7Vo8hwWVUhw8dSH");
		headers.add("host", "models.dacadoo.com");
		headers.add("content-type", "application/json");
		return headers;
	}

//	public RestTemplate restTemplate()             throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
//TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
//
//SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
//                .loadTrustMaterial(null, acceptingTrustStrategy)
//                .build();
//
//SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
//
//CloseableHttpClient httpClient = HttpClients.custom()
//                .setSSLSocketFactory(csf)
//                .build();
//
//HttpComponentsClientHttpRequestFactory requestFactory =
//                new HttpComponentsClientHttpRequestFactory();
//
//requestFactory.setHttpClient(httpClient);
//RestTemplate restTemplate = new RestTemplate(requestFactory);
//return restTemplate;
//}
}
