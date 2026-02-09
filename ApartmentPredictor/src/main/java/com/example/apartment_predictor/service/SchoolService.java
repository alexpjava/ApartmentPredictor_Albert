package com.example.apartment_predictor.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apartment_predictor.model.School;
import com.example.apartment_predictor.repository.SchoolRepository;

@Service
public class SchoolService {

     @Autowired
    SchoolRepository schoolRepository;

    public Iterable<School> findAll() {
        return schoolRepository.findAll();
    }
    public School createSchool(School school){
        return schoolRepository.save(school);
    }

    public School findSchoolById (String id){
        Optional<School> found = schoolRepository.findById(id);
        if ( found.isPresent()) return found.get() ;
        else return null;

    }
    

}
