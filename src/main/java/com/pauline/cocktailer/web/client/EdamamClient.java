package com.pauline.cocktailer.web.client;

import com.pauline.cocktailer.configuration.properties.EdamamConfigurationProperties;
import com.pauline.cocktailer.domain.edamam.EdamamResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class EdamamClient {

    private final RestTemplate restTemplate;
    private final EdamamConfigurationProperties properties;

//    private String url = "https://api.edamam.com/api/recipes/v2?type=public&q=strawberry&app_id=32992d08&app_key=1f6334ce4351cb7b41e17ab8433c2af4&health=alcohol-free&dishType=Drinks";

    public ResponseEntity<EdamamResponse> searchRecipesByIngredients(String ingredients){
        URI url = UriComponentsBuilder.newInstance()
                .scheme(properties.getScheme())
                .host(properties.getHost())
                .path(properties.getPath())
                .queryParam("type", "public")
                .queryParam("q", ingredients)
                .queryParam("app_id", properties.getAppId())
                .queryParam("app_key",properties.getAppKey())
                .queryParam("health", "alcohol-free")
                .queryParam("dishType", "Drinks")
                .build()
                .toUri();
        return restTemplate.getForEntity(url, EdamamResponse.class);
    }

}
