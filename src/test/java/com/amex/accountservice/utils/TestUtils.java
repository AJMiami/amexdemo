package com.amex.accountservice.utils;

import com.amex.accountservice.vo.Account;
import com.amex.accountservice.vo.Address;

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
        account.setAddress(new Address());
        account.setTelephoneNumber(1234567890L);
        return account;
        
    }

}
