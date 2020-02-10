package java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;
import java.net.http.HttpClient.Version;

public class HttpClientAsyncHttpVersion2 {

	public static void main(String[] args) {
		//Used Builder pattern and got Http 2 client
		HttpClient httpClient = HttpClient.newBuilder().version(Version.HTTP_2).build();
		HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://google.com")).GET().build();
		// note we are returning this in completable future
		CompletableFuture<HttpResponse<String>> responseFuture = httpClient.sendAsync(httpRequest, BodyHandlers.ofString());
		// We are writing a callback below to get the version in a non-blocking way
		responseFuture.thenAccept(response -> System.out.println("Future THREAD:" + Thread.currentThread().getName() + ":"+ response.version()));
		// we want our main thread to wait so we write a join.		
		responseFuture.join();
		System.out.println("MAIN THREAD:" + Thread.currentThread().getName());

	}

}
