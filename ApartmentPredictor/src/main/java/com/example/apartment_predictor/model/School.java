package com.example.apartment_predictor.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class School {
    @Id
    protected String Id;
    private String name;
    private String address;
    private String city;
    private String zipCode;
    private int rating;
    private boolean isPublic;

    @ManyToMany(mappedBy = "schools")
    private List<Apartment> apartments = new ArrayList<>();

    

    public School() {
        this.Id = UUID.randomUUID().toString();
    }


    public School(String name, String address, String city, String zipCode, int rating, boolean isPublic) {
        this.Id = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.rating = rating;
        this.isPublic = isPublic;
    }

    // Getters and setters
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

    @Override
    public String toString() {
        return "School [Id=" + Id + ", name=" + name + ", address=" + address + ", city=" + city + ", zipCode="
                + zipCode + ", rating=" + rating + ", isPublic=" + isPublic + "]";
    }

    
}

