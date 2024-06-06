package com.rainhard.prac.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rainhard.prac.factories.HttpClientFactory;
import com.rainhard.prac.pojo.users.User;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

public class HttpClientService {

    static final String url = "https://jsonplaceholder.typicode.com/users";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final HttpClient client = HttpClientFactory.getHttpClient();



    public void getAllUsers() throws URISyntaxException {

        try{

            HttpClient client = HttpClientFactory.getHttpClient();

            HttpRequest request = HttpRequest.newBuilder().uri(new URI(url))
                    .GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); //Read json as String

            if(response.statusCode() == 200) {

                String responseBody = response.body();
                List<User> users = objectMapper().readValue(responseBody, new TypeReference<List<User>>() {});
                System.out.println("users:" + users);

            }else if (response.statusCode() == 404) {
                System.out.println("Not Found. status code: " + response.statusCode());
            }else{
                System.out.println("There's an error");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public void getUserById() throws URISyntaxException {

        try{

            HttpClient client = HttpClientFactory.getHttpClient();

            HttpRequest request = HttpRequest.newBuilder().uri(new URI(url))
                    .GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); //Read json as String

            if(response.statusCode() == 200) {

                String responseBody = response.body();
                List<User> users = objectMapper().readValue(responseBody, new TypeReference<List<User>>() {});
                users.stream()
                        .filter(user -> user.getId() == 1)
                        .toList()
                        .forEach(System.out::println);

            }else if (response.statusCode() == 404) {
                System.out.println("Not Found. status code: " + response.statusCode());
            }else{
                System.out.println("There's an error");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public List<User> findAllUser() throws URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).build();
        return request(request, new TypeReference<List<User>>() {
        });
    }

    public Optional<User> findUserByName(String name) throws URISyntaxException {
        return findAllUser().stream()
                .filter(userName -> userName.getName().equals(name))
               .findFirst();
    }

    private <T> T request(HttpRequest httpRequest, TypeReference<T> tTypeReference) throws URISyntaxException{
        try{
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 200) {
                String body = response.body();
                return objectMapper().readValue(body, tTypeReference);
            }else if (response.statusCode() == 404) {
                System.out.println("Not Found. status code: " + response.statusCode());
            }else{
                System.out.println("There's an error");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
        return  null;
    }

    private ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
