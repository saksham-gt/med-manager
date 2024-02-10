package htf.medmanager.client;


import java.util.Map;

public interface INeureloClient {

    <T> T get(String id, String resourceUri, Class<T> responseType);

    void delete(String id, String resourceUri);

    <T> T post(String requestString, String resourceUri, Class<T> responseType);

    <T> T patch(String id, String resourceUri, String requestString, Class<T> responseType);

    <T> T get(String resourceUri, Class<T> responseType, Map<String, String> filters);
}
