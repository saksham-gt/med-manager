package htf.medmanager.client.impl;

import htf.medmanager.client.INeureloClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class NeureloClientImpl implements INeureloClient {

    private final String authKey = "neurelo_9wKFBp874Z5xFw6ZCfvhXdOEMGEmsLgkuIqL2zxAkmnB/UEu9bNuFPLJ4r9l3jJ7BzN/uTFOXghukWZ+Z20nLT/txW+in77VT4KjSaIPsV0mnY17bNaJv1WahD0ZBQfh87eSss4CUcc7xR7ZAimtV9T6j08MPb02wpBTD6d4/VxUBBAqmUMaZDaVefJOlOIS_a+MFAEEZY2jjYyBgG/1LtxU9GAIwTocRccOD43FrMNI=";

    private final String baseUrl = "https://ap-south-1.aws.neurelo.com";

    private final String userURI = "/rest/user/";

    private final String medicineURI = "/rest/medicine/";

    public final String userByMobileURI = "/rest/user/medicine";

//    public HttpResponse<T> executePOSTRequest(HttpRequest request) throws IOException, InterruptedException {
//        HttpClient client = HttpClient.newHttpClient();
//        HttpResponse<T> response = client.send(request,
//                HttpResponse.BodyHandlers);
//    }
}
