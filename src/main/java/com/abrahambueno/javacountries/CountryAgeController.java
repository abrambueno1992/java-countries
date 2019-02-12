package com.abrahambueno.javacountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class CountryAgeController {
    @RequestMapping("/age")
    public ArrayList<Country> getCountriesGreaterThan(@RequestParam(value = "age") int age) {
        ArrayList<Country> newList = new ArrayList<Country>();
        for (Country e: JavacountriesApplication.ourCountryList.countryList) {
            if (e.getAge() >= age) {
                newList.add(e);
            }
        }
        newList.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        return newList;
    }

    @RequestMapping("/max")
    public Country getCountryMaxAge() {
        int maxAge = Integer.MIN_VALUE;
        Country maxAgeCountry = new Country("fefe", 222, 22, 2) ;
        for (Country e : JavacountriesApplication.ourCountryList.countryList) {
            maxAge = Math.max(maxAge, e.getAge());
            if (maxAge == e.getAge()) {
                maxAgeCountry = e;
            }
        }
        return maxAgeCountry;
    }


    @RequestMapping("/min")
    public Country getCountryMinAge() {
        double minAge = Double.POSITIVE_INFINITY;
        Country minAgeCountry = new Country("fefe", 222, 22, 2) ;
        for (Country e : JavacountriesApplication.ourCountryList.countryList) {
            minAge = Math.min(minAge, e.getAge());
            if (minAge == e.getAge()) {
                minAgeCountry = e;
            }
        }
        return minAgeCountry;
    }
}
