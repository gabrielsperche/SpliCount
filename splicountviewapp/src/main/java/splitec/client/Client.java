package splitec.client;

import entities.MessageResponse;
import splitec.Constants;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client implements Constants {

    public static MessageResponse get(String url) {
        try {

            HttpRequest httpClient = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            return handleRequest(httpClient);

        } catch (Exception e) {
            return new MessageResponse(e.getLocalizedMessage(), false);
        }
    }

    public static MessageResponse post(String url, String body) {
        try {

            HttpRequest httpClient = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            return handleRequest(httpClient);

        } catch (Exception e) {
            return new MessageResponse(e.getLocalizedMessage(), false);
        }
    }

    public MessageResponse delete(String url) {
        try {

            HttpRequest httpClient = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();

            return handleRequest(httpClient);

        } catch (Exception e) {
            return new MessageResponse(e.getLocalizedMessage(), false);
        }
    }

    public static MessageResponse handleRequest(HttpRequest client) {
        try {
            HttpResponse<String> response = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.NORMAL)
                    .build()
                    .send(client, HttpResponse.BodyHandlers.ofString());

            //Validação da resposta
            if (String.valueOf(response.statusCode()).equals("202")
                    || String.valueOf(response.statusCode()).equals("201")
                    || String.valueOf(response.statusCode()).equals("200")) {
                return new MessageResponse(response.body(), true);
            } else {
                return new MessageResponse(REQUEST_ERROR + response.statusCode(), false);
            }
        } catch (Exception e) {
            return new MessageResponse(e.getLocalizedMessage(), false);
        }
    }
}
