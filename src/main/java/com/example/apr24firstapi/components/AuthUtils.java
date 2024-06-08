package com.example.apr24firstapi.components;

import com.example.apr24firstapi.dtos.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class AuthUtils {

    private RestTemplate restTemplate;

    @Autowired
    public AuthUtils(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean validateToken(String tokenValue){

        String body = "{\"token\":\"" + tokenValue + "\"}";  // is escape character. This token is similar to the one we created in postman
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(body, headers);

        try {
            Token token = this.restTemplate.postForObject("http://localhost:8080/user/validate-token", httpEntity, Token.class);
            return token != null;  // if token is present we return true, else we will return false
        } catch (Exception e){
            return false;
        }
    }
}
