package dev.patika.thirdhomework2.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Double> usdToTry(@PathVariable int amount){
        ResponseEntity<String> result= restTemplate.getForEntity(webUrl, String.class);
        String dollar = result.getBody();
        double d=Double.parseDouble(dollar)*amount;
        return new ResponseEntity<>(d, HttpStatus.OK);
    }


    @GetMapping("/tryToUsd/{amount}")
    public ResponseEntity<Double> tryToUsd(@PathVariable int amount){
        ResponseEntity<String> result= restTemplate.getForEntity(webUrl, String.class);
        String dollar = result.getBody();
        double d=amount/Double.parseDouble(dollar);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }


}
