package com.restdacadoo.dacadoojersy;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.client.JerseyWebTarget;

public class ClientResponseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Form form = new Form();
		form.param("grant_type", "password");
		form.param("scope", "all");
		form.param("username", "sharad.chopra@oracle.com");
		form.param("password", "Pearl100");
		form.param("client_id", "5c5305003d1c80918781a118");
		form.param("client_secret", "Pw1eV6mKt03y41YpFwGOAen4WK4ow3oHFGgDN42s");

		ClientConfig config = new ClientConfig();
		java.net.URI uri = null;
		try {

			String protocol = "http";
			String host = "www-proxy.us.oracle.com";
			int port = 80;
			String path = null;
			String auth = null;
			String fragment = null;
			uri = new URI(protocol, auth, host, port, path, null, fragment);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		config.property(ClientProperties.PROXY_URI, uri);
		config.connectorProvider(new ApacheConnectorProvider());
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target("https://api-int.dacadoo.com/1/oauth/token");
		javax.ws.rs.core.Response response = target.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).header("Content-Type", "application/x-www-form-urlencoded")
				.method("POST", Entity.form(form));

		System.out.println(response);
		System.out.println(response.readEntity(String.class));
	};

	public static void getResponse1() {
		Form form = new Form();
		form.param("grant_type", "samples");
		form.param("id", "2ZwqWBdksfjkads6Q8yNW3s58LNeOMucJeb");
		form.param("secret", "HGoslJTZOqA1GCEH");
		form.param("scope", "dkfflJTZOqA1GCEH");
		JerseyClientBuilder jerseyClientBuilder = new JerseyClientBuilder();
		JerseyWebTarget jerseyWebTarget = jerseyClientBuilder.build()
				.target("https://api-int.dacadoo.com/1/oauth/token");
		javax.ws.rs.core.Response response = jerseyWebTarget.request().accept(MediaType.APPLICATION_FORM_URLENCODED)
				.post(Entity.form(form));
		System.out.println(response);
		System.out.println(response.getEntity());
	}

}
