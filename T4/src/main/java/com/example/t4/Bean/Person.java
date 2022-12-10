package com.example.t4.Bean;
import java.time.LocalDate;
import java.util.Date;

public class  Person {
    private long ID;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private long phoneNum;
    private LocalDate dob;
    private String passwords;


    public Person(long ID, String firstName, String lastName, String address, String email, long phoneNum, LocalDate dob, String passwords) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNum = phoneNum;
        this.dob = dob;
        this.passwords = passwords;
    }


    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
