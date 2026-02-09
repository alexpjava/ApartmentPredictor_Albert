package com.example.apartment_predictor.utils;

import org.springframework.stereotype.Component;

import com.example.apartment_predictor.model.School;
import com.example.apartment_predictor.service.SchoolService;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.javafaker.Faker;

@Component
public class PopulateSchoolsDB {

@Autowired
SchoolService schoolService;

    public int populateSchools(int qty) {
        int qtySchoolsCreated = 0;
        if (qty <= 0) return 0;

        Faker faker = new Faker();
        ThreadLocalRandom rnd = ThreadLocalRandom.current();


        for (int i = 0; i < qty; i++) {

            String name = faker.country().name();
            String address = faker.address().fullAddress();
            String city = faker.address().cityName();
            String zipCode = faker.address().zipCode();
            int rating = rnd.nextInt(1, 6);
            boolean isPublic = rnd.nextBoolean();



            School school = new School(
                    name,
                    address,
                    city,
                    zipCode,
                    rating, // rating between 1 and 5
                    isPublic // isPublic
            );

            schoolService.createSchool(school);

            School schoolById = schoolService.findSchoolById(school.getId());
            if (schoolById != null) {
                qtySchoolsCreated++;
                System.out.println(
                        "School #" + qtySchoolsCreated +
                         "/" + qty + " created populateDB: " + schoolById);
            }

        }
        return qtySchoolsCreated;
    }

}
