package com.amex.accountservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * this entity {@link AccountEntity} holds the data that need to be persisted in the database , also return object from DB
 * @author ajits
 *
 */
@Entity

@Table(name = "ACCOUNT_INFO")
public class AccountEntity {

    //Use Joda beans or Lonbok or any other equivalent to create this class
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ACCOUNT_NUMBER" , nullable=false, length = 10)
    Long accountNumber;
    
    @Column(name="TELEPHONE_NUMBER" , nullable=true, length = 10)
    Long telephoneNumber;
    
    @Column(name="ADDRESS_LINE1")
    String addressLine1;
    
    @Column(name="ADDRESS_LINE2")
    String addressLine2;
    
    @Column(name="CITY")
    String City;
    
    @Column(name="STATE")
    String State;
    
    @Column(name="ZIP")
    String Zip;
    

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(Long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String zip) {
        Zip = zip;
    }
    
    
    

}
