package htf.medmanager.client.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import htf.medmanager.client.INeureloClient;
import org.springframework.stereotype.Repository;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

@Repository
public class NeureloClientImpl implements INeureloClient {

    private final String headerKey = "X-API-KEY";
    private final String authKey = "neurelo_9wKFBp874Z5xFw6ZCfvhXdOEMGEmsLgkuIqL2zxAkmnB/UEu9bNuFPLJ4r9l3jJ7BzN/uTFOXghukWZ+Z20nLT/txW+in77VT4KjSaIPsV0mnY17bNaJv1WahD0ZBQfh87eSss4CUcc7xR7ZAimtV9T6j08MPb02wpBTD6d4/VxUBBAqmUMaZDaVefJOlOIS_a+MFAEEZY2jjYyBgG/1LtxU9GAIwTocRccOD43FrMNI=";

    private final String baseUrl = "https://ap-south-1.aws.neurelo.com";


    @Override
    public <T> T patch(String id, String resourceUri, String requestString, Class<T> responseType) {
        HttpClient client = HttpClient.newHttpClient();
        String uri = String.format(baseUrl + resourceUri + "/%s", id);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header(headerKey, authKey)
                .method("PATCH", HttpRequest.BodyPublishers.ofString(requestString))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return parseResponse(response.body(), responseType);
        }catch (Exception e) {
            System.out.println("PATCH Request Failed! Request String: " + requestString);
            return null;
        }
    }

    @Override
    public <T> T post(String requestString, String resourceUri, Class<T> responseType) {
        HttpClient client = HttpClient.newHttpClient();
        String uri = String.format(baseUrl + resourceUri + "/__one");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header(headerKey, authKey)
                .POST(HttpRequest.BodyPublishers.ofString(requestString))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return parseResponse(response.body(), responseType);
        } catch (Exception e) {
            System.out.println("POST Request Failed! Request String: " + requestString);
            return null;
        }
    }

    @Override
    public <T> T get(String id, String resourceUri, Class<T> responseType) {
        HttpClient client = HttpClient.newHttpClient();
        String uri = String.format(baseUrl + resourceUri + "/%s", id);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header(headerKey, authKey)
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return parseResponse(response.body(), responseType);
        } catch (Exception e) {
            System.out.println("GET Request Failed! Resource Id: " + id);
            return null;
        }
    }

    @Override
    public void delete(String id, String resourceUri) {
        HttpClient client = HttpClient.newHttpClient();
        String uri = String.format(baseUrl + resourceUri + "/%s", id);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header(headerKey, authKey)
                .DELETE()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println("DELETE Request Failed! Resource Id: " + id);
        }
    }

    @Override
    public <T> T get(String resourceUri, Class<T> responseType, Map<String, String> filters) {
        HttpClient client = HttpClient.newHttpClient();
        String uri = String.format(baseUrl + resourceUri);
        StringBuilder queryParams = new StringBuilder("?");
        for(Map.Entry<String, String> e : filters.entrySet()) {
            queryParams.append(e.getKey()).append("=").append(e.getValue()).append("&");
        }
        queryParams.deleteCharAt(queryParams.length() - 1);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri + queryParams))
                .header(headerKey, authKey)
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return parseResponse(response.body(), responseType);
        } catch (Exception e) {
            System.out.println("GET Request Failed! Filters -" + filters);
            return null;
        }
    }

    private <T> T parseResponse(String response, Class<T> responseType) {
        System.out.println("PARSING RESPONSE -" + response);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response, responseType);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
