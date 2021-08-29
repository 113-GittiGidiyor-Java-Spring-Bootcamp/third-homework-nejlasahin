package dev.patika.thirdhomework2.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/api")
public class RestClientController {

    private static final String webUrl = "http://localhost:8080/api/getDollar";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/usdToTry/{amount}")
    public double usdToTry(@PathVariable int amount){
        ResponseEntity<String> result= restTemplate.getForEntity(webUrl, String.class);
        double dollar = Double.parseDouble(result.getBody());
        return amount;
    }


    @GetMapping("/tryToUsd/{amount}")
    public double tryToUsd(@PathVariable int amount){
        return amount;
    }


}
