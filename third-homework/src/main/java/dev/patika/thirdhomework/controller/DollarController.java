package dev.patika.thirdhomework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/getDollar")
public class DollarController {

    //SORU-4 için hazırlanan endpoint

    @GetMapping
    public double getDollar(){
        double dollar = 8.35;
        return dollar;
    }
}
