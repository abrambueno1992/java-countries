package com.abrahambueno.javacountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/begin") // begin?letter=
    public ArrayList<Country> getCountryDetail(@RequestParam(value = "letter") String letter) {
        ArrayList<Country> newList = new ArrayList<Country>();
//                JavacountriesApplication.ourCountryList.countryList.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
//        return JavacountriesApplication.ourCountryList.countryList;
        newList.add(JavacountriesApplication.ourCountryList.finalCountry(e -> ((e.checkCharValue(letter) != "NO")) ));
        newList.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        return newList;
//        return JavacountriesApplication.ourCountryList.countryList;
//        return JavacountriesApplication.ourCountryList.finalCountry(e -> (e.checkCharValue() >=( (int) letter)));
    }

    @RequestMapping("/size")
    public ArrayList<Country> getCountryBySizeChar(@RequestParam(value = "letters") String letters) {
        return JavacountriesApplication.ourCountryList.countryList;
    }
}
