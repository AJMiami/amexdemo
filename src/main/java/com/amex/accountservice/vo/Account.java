package com.amex.accountservice.vo;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

/**
 * Class {@link Account} is used as a VO to be accepted and responded back thr
 * rest endpoints
 * 
 * @author ajits
 *
 */
public class Account implements Serializable {

    private static final long serialVersionUID = 4163881109605779796L;

    @NotEmpty
    Long telephoneNumber;
    @NotEmpty
    Address address;

    // GETTER SETTER SECTION
    
    public Long getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(Long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Parametersied constructor for the class {@link Account}}
     * @param telephoneNumber
     * @param address
     */
    public Account(@NotEmpty Long telephoneNumber, @NotEmpty Address address) {
        super();
        this.telephoneNumber = telephoneNumber;
        this.address = address;
    }

    /**
     * default constructor for the class {@link Account}}
     */
    public Account() {
        
    }
}
