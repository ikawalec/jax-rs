import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

public class App {

    public static final String API_URL = "http://localhost:9090/jax-rs/api/";

    public static void main(String[] args){

        Client client = Client.create();
        WebResource webResource = client.resource(API_URL + "test/sayHello");

        String result = webResource.accept(MediaType.TEXT_PLAIN).get(String.class);
        System.out.println(result);

        webResource = client.resource(API_URL + "product");
        webResource.post("strawberry");

        String productToAdd = "melon";
        ClientResponse clientResponse = webResource.accept(MediaType.TEXT_PLAIN).post(ClientResponse.class, productToAdd);
        if(clientResponse.getStatus() != 201){
            System.out.println("Returned status: " + clientResponse.getStatus());
        }

        webResource = client.resource(API_URL + "product/list");
        result = webResource.accept(MediaType.TEXT_PLAIN_TYPE).get(String.class);
        System.out.println(result);

        // form
        MultivaluedMap<String, String> formParam = new MultivaluedMapImpl();
        formParam.add("name", "melon");
        formParam.add("limit", "2");

        webResource = client.resource(API_URL + "product/search");
        clientResponse = webResource.type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, formParam);
        if(clientResponse.getStatus() == 200){
            result = clientResponse.getEntity(String.class);
            System.out.println(result);
        } else {
            System.out.println("Status: " + clientResponse.getStatus());
        }

    }
}
