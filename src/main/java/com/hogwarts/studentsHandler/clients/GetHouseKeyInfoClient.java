package com.hogwarts.studentsHandler.clients;

import com.hogwarts.studentsHandler.dto.clients.HouseKeyInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetHouseKeyInfoClient {

    public HouseKeyInfo execute(String houseKey) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<HouseKeyInfo> houseKeyInfoResponseEntity =
                restTemplate.exchange("https://api-harrypotter.herokuapp.com/{houseKey}", HttpMethod.GET,
                        entity, HouseKeyInfo.class, houseKey);
        if (houseKeyInfoResponseEntity.getStatusCode().isError()) {
            return null;
        }
        return houseKeyInfoResponseEntity.getBody();
    }
}

