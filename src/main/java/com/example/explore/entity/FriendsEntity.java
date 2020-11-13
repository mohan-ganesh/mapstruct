package com.example.explore.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "friends")
@EntityScan(basePackages = {"com.example.explore"})
public class FriendsEntity {

    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String address1;
    private String address2;
    private String zip;
    private String state;


    public FriendsEntity() {

    }

    public FriendsEntity(String firstName, String lastName, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;


    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email_address", nullable = true)
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }



    @Column(name = "address1",nullable = true)
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Column(name = "address2",nullable = true)
    public String getAddress2() {return address2;}
    public void setAddress2(String address2) {this.address2 = address2;}

    @Column(name = "zip",nullable = true)
    public String getZip() {return zip;}
    public void setZip(String zip) {this.zip = zip;}

    @Column(name = "state",nullable = true)
    public String getState() {return state;}
    public void setState(String state) {this.state = state;}



}
