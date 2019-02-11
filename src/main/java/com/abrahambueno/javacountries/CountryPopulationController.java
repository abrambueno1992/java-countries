package com.abrahambueno.javacountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

// localhost:8080/populartion/max
@RestController
@RequestMapping("/population")
public class CountryPopulationController {
    @RequestMapping("/max")
    public double getCountryMaxPopulation() {
        double max = 0;
        for (Country e : JavacountriesApplication.ourCountryList.countryList) {
            max = Math.max(max, e.getPopulation());
        }
        return max;
//        return JavacountriesApplication.ourCountryList.countryList.sort((e1, e2) -> max = Math.max(e1.getPopulation(), e2.getPopulation()));
    }

    @RequestMapping("/min")
    public double getCountryMinPopulation() {
        double min = Double.POSITIVE_INFINITY;
        for (Country e: JavacountriesApplication.ourCountryList.countryList) {
            min = Math.min(min, e.getPopulation());
        }
        return min;
    }

    @RequestMapping("size")
    public ArrayList<Country> getCountryPopulationGreaterThan(@RequestParam(value = "people") double people) {
        ArrayList<Country> newList = new ArrayList<Country>();
        for (Country e: JavacountriesApplication.ourCountryList.countryList) {
            if (e.getPopulation() >= people) {
                newList.add(e);
            }
        }
        newList.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        return newList;
    }
}
