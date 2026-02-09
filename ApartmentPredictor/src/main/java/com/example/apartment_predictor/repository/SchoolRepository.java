package com.example.apartment_predictor.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.apartment_predictor.model.School;


public interface SchoolRepository extends CrudRepository<School, String> {
}
