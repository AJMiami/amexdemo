package com.amex.accountservice.vo;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * Class {@link Address} is to VO to handle Address attached to the account
 * 
 * @author ajits
 *
 */

public class Address implements Serializable {

    private static final long serialVersionUID = 1299395306291136719L;

    @NotEmpty
    String addressLine1;

    String addressLine2;

    @NotEmpty
    String City;

    @NotEmpty
    @Min(2)
    @Max(50)
    String State;

    @NotEmpty
    @Max(9)
    @Pattern(regexp = "^[0-9]")
    String Zip;

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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    /**
     * Paramtertized contructor for the class {@Link Address}
     * @param addressLine1
     * @param addressLine2
     * @param city
     * @param state
     * @param zip
     */

    public Address(@NotEmpty String addressLine1, String addressLine2, @NotEmpty String city,
            @NotEmpty @Min(2) @Max(50) String state, @NotEmpty @Max(9) @Pattern(regexp = "^[0-9]") String zip) {
        super();
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        City = city;
        State = state;
        Zip = zip;
    }
    
    /**
     * default contructor for the class {@Link Address}
     */
    
    public Address() {
        
    }
}
