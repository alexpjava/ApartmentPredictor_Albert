package com.example.apartment_predictor.controller;

import org.springframework.beans.factory.annotation.Autowired; // Añade esto
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController; // Añade esto
import org.springframework.web.bind.annotation.RequestMapping; // Opcional pero recomendado

import com.example.apartment_predictor.utils.PopulateSchoolsDB;


@CrossOrigin(origins = "http://localhost:5173")
@RestController // 1. Indica que esto es un controlador API
@RequestMapping("/api/school") // Opcional: para que la URL sea /api/populate
public class SchoolRestController {

    // 2. Inyectamos la instancia de la clase de utilidad
    @Autowired
    private PopulateSchoolsDB populateSchoolsDB;

    @GetMapping("/populate")
    public ResponseEntity<String> populateSchools(@RequestParam int qty) {
        
        // 3. Llamamos al método usando la instancia 'populateSchoolsDB' (en minúsculas)
        int qtySchoolsCreated = populateSchoolsDB.populateSchools(qty);
        
        if (qtySchoolsCreated > 0)
            return ResponseEntity.ok("Populated schools: " + qtySchoolsCreated);
        else
            return ResponseEntity.badRequest().body("Failed to populate schools");
    }
}