package com.rainhard.prac.factories;

import java.net.http.HttpClient;
import java.time.Duration;

public class HttpClientFactory {

        private static HttpClient httpClient;

        private HttpClientFactory(){
        }

        public static HttpClient getHttpClient(){
            if(httpClient == null){
                httpClient = HttpClient
                        .newBuilder()
                        .connectTimeout(Duration.ofSeconds(2000))
                        .build();
            }
            return httpClient;
        }


}




