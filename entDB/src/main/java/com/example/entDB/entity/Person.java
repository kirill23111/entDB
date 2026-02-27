package com.example.entDB.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "persons")
@IdClass(PersonId.class)
public class Person {

    @Id
    private String name;

    @Id
    private String surname;

    @Id
    private Integer age;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "city_of_living")
    private String cityOfLiving;

    public Person() {}

    public Person(String name, String surname, Integer age, String phoneNumber, String cityOfLiving) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.cityOfLiving = cityOfLiving;
    }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public Integer getAge() { return age; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getCityOfLiving() { return cityOfLiving; }

    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setAge(Integer age) { this.age = age; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setCityOfLiving(String cityOfLiving) { this.cityOfLiving = cityOfLiving; }
}