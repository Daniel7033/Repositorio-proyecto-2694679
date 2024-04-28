package com.sena.security.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Person extends ABaseEntity{
    @Column(name = "type_document", length = 10, nullable = false)
    private String typeDocument;

    @Column(name = "document", length = 20, nullable = false)
    private String document;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "phone", length = 50, nullable = false)
    private String phone;

    @Column(name = "gender", length = 15, nullable = false)
    private String gender;

    @Column(name = "address", length = 100, nullable = false)
    private String address;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBitrth;

    // @ManyToOne(fetch = FetchType.EAGER, optional = false)
    // @JoinColumn(name = "city_id", nullable = false)
    // private City city;

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBitrth() {
        return dateOfBitrth;
    }

    public void setDateOfBitrth(Date dateOfBitrth) {
        this.dateOfBitrth = dateOfBitrth;
    }

    // public City getCity() {
    //     return city;
    // }

    // public void setCity(City city) {
    //     this.city = city;
    // }
    
}
