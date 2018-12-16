package com.library.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name="login")
    @NotBlank(message = "Can't be empty")
    private String login;

    @Column(name="password")
    @NotBlank(message = "Can't be empty")
    @Min(value = 6, message = "The min value for this field is 6")
    private String password;

    @Column(name="gender")
    @NotBlank(message = "Can't be empty")
    private String gender;

    @Column(name="first_name")
    @NotBlank(message = "Can't be empty")
    private String firstName;

    @Column(name="second_name")
    @NotBlank(message = "Can't be empty")
    private String secondName;

    @Column(name="last_name")
    @NotBlank(message = "Can't be empty")
    private String lastName;

    @Column(name="age")
    @NotNull(message = "Can't be empty")
    @Min(value = 1,message = "Age can't be less then 1 year")
    private Integer age;

    @Column(name="phone_number")
    @NotBlank(message = "Can't be empty")
    @Min(value = 6, message = "The min value for this field is 9")
    private String phoneNumber;

    @Column(name="city")
    @NotBlank(message = "Can't be empty")
    private String city;

    @Column(name="region")
    @NotBlank(message = "Can't be empty")
    private String region;

    @Column(name="country")
    @NotBlank(message = "Can't be empty")
    private String country;

    public Account() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}
