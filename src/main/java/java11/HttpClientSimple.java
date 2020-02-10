package java11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpClientSimple {

	public static void main(String[] args) throws IOException, InterruptedException {
		// you can also use builder pattern of HttpClient
		HttpClient httpClient = HttpClient.newHttpClient();
		// used builder pattern of HttpRequest
		HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://pluralsight.com")).GET().build();
		//send method is a blocking
		HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());
		System.out.println(httpResponse.headers().map());

	}

}
