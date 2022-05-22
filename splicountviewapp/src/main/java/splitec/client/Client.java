package splitec.client;

import splitec.Constants;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client implements Constants {

    public String get(String url) throws Exception {
        try {

            HttpRequest httpClient = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            return handleRequest(httpClient);

        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }

    public static String post(String url, String body) {
        try {

            HttpRequest httpClient = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            return handleRequest(httpClient);

        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }

    public String delete(String url) throws Exception {
        try {

            HttpRequest httpClient = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();

            return handleRequest(httpClient);

        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }

    public static String handleRequest(HttpRequest client) throws Exception {
        try {
            HttpResponse<String> response = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.NORMAL)
                    .build()
                    .send(client, HttpResponse.BodyHandlers.ofString());

            //Validação da resposta
            if (String.valueOf(response.statusCode()).equals("202")
                    || String.valueOf(response.statusCode()).equals("201")
                    || String.valueOf(response.statusCode()).equals("200")) {
                return response.body();
            } else {
                return REQUEST_ERROR + response.statusCode();
            }
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }

}
