package com.abrahambueno.javacountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

// localhost:8080/names/all
@RestController
@RequestMapping("/names")
public class CountryController {
    @RequestMapping("/all")
    public ArrayList<Country> getAllCountries() {
        JavacountriesApplication.ourCountryList.countryList.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        return JavacountriesApplication.ourCountryList.countryList;
    }
}
