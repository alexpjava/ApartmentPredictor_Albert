package com.example.apartment_predictor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.apartment_predictor.utils.PopulateSchoolsDB;

public class SchoolRestController {


    @GetMapping("/populate")
    public ResponseEntity<String> populateSchools(@RequestParam int qty) {
        // CALL to PopulateDB.populateSchools() method
        // to populate the database with random schools
        int qtySchoolsCreated = PopulateSchoolsDB.populateSchools(qty);
        if (qtySchoolsCreated > 0)
            return ResponseEntity.ok("Populated schools: " + qtySchoolsCreated);
        else
            return ResponseEntity.badRequest().body("Failed to populate schools");
    }

}


 