package com.amex.accountservice.utils;

import com.amex.accountservice.vo.Account;
import com.amex.accountservice.vo.Address;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * the class {@link TestUtils} contains helper methids t full fill testing
 * @author ajits
 *
 */
public class TestUtils {
    
/**
 * method to create a dumy objevt for testing
 * @return
 */
    
    public static Account getAccountInfo() {
        Account account=new Account();
        account.setAddress(new Address("address1","Address2","city", "state", "12345"));
        account.setTelephoneNumber(1234567890L);
        return account;
        
    }
    
    /**
     * method to converto an object to JSON String
     * @param obj
     * @return
     */
    
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
