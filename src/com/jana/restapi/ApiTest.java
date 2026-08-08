package com.jana.restapi;

//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
public class ApiTest {

//	Starting with Java 11, Oracle completely removed Java EE modules (like JAX-WS, 
//	JAXB, and related web-service specifications) from the core Java Development Kit (JDK).

	public static void main(String[] args) {	
		// 1. JAX-RS 2.1 API Specification
//	    implementation 'javax.ws.rs:javax.ws.rs-api:2.1.1'
//
//	    // 2. Jersey Client implementation engine
//	    implementation 'org.glassfish.jersey.core:jersey-client:2.35'
//	    implementation 'org.glassfish.jersey.inject:jersey-hk2:2.35'


		Client client = ClientBuilder.newClient();
		String response = client.target("https://example.com")
		                        .request(MediaType.APPLICATION_JSON)
		                        .get(String.class);
		
	}
	
//	REST API calls in OBDX
//	JAX-RS / Jersey Client
//	Used for internal or external REST service calls static with ClientBuilder
//	with WebTarget;
//	with and; Invocation.Builder.
//	Example: SMS Banking RestClient invokes JSON APIs using GET, POST, PUT, and PATCH.
//	[RestClient.java (line 72)](/Users/janakaran/Documents/OBDX/KVB/BackEnd/base/222/Middleware/modules/com.ofss.digx.module.smsbanking/com.ofss.digx.appx.smsbanking.endpoint/src/main/java/com/ofss/digx/common/client/RestClient.java:72)
//
//	HttpURLConnection / HttpsURLConnection
//	Used by legacy/custom HTTP integrations.
//	Example: HttpExchanger connects to external HTTP/HTTPS resources using GET or POST.
//	[HttpExchanger.java (line 27)](/Users/janakaran/Documents/OBDX/KVB/BackEnd/base/222/Middleware/extsystem/com.ofss.extsystem/src/main/java/com/ofss/extsystem/framework/extsystems/HttpExchanger.java:27)
//
//	Apache HttpClient
//	Used for push notifications and third-party HTTP integrations.
//	Example: FCMDispatcher sends JSON POST requests to Firebase Cloud Messaging using CloseableHttpClient and HttpPost.
//	[FCMDispatcher.java (line 64)](/Users/janakaran/Documents/OBDX/KVB/BackEnd/base/222/Middleware/modules/com.ofss.digx.module.alerts/com.ofss.digx.app.alerts.service/src/main/java/com/ofss/digx/domain/ep/service/dispatch/FCMDispatcher.java:64)
//
//	Pushy APNs HTTP/2 Client
//	Used for Apple push notifications.
//	Example: APNSDispatcher creates an ApnsClient through ApnsClientBuilder for Apple Push Notification Service calls.
//	[APNSDispatcher.java (line 109)](/Users/janakaran/Documents/OBDX/KVB/BackEnd/base/222/Middleware/modules/com.ofss.digx.module.alerts/com.ofss.digx.app.alerts.service/src/main/java/com/ofss/digx/domain/ep/service/dispatch/APNSDispatcher.java:109)
}
