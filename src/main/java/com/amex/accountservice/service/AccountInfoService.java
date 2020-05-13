package com.amex.accountservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amex.accountservice.entity.AccountEntity;
import com.amex.accountservice.repository.AccountInfoRepository;
import com.amex.accountservice.vo.Account;
import com.amex.accountservice.vo.Address;

/**
 * Class{@link AccountInfoService} contains methods thos are used to process account information that must be saved.
 * THe class also supports readd functions to get the data stored in database in the client expected format
 * 
 * @author ajits
 *
 */

//NOTE: NO INTERFACE IS ADDED TO THE SERVICE CLASS

@Service
public class AccountInfoService {
    
    @Autowired
    private AccountInfoRepository accountRepository;

    /**
     * method looks up for a record based on the account number passed in. it retrieves the telephone number and address attached to the account
     * @param accountNumber
     * @return
     */
    public Optional<Account> get(Long accountNumber) {
        
        Account accnt=new Account();
        Optional<AccountEntity> accntObj=accountRepository.findById(accountNumber);
        
        accntObj.ifPresent(item -> {
            System.out.println("from DB = " + item.getAccountNumber());
            Address addr = new Address (item.getAddressLine1(), item.getAddressLine2(),item.getCity(), item.getState(), item.getZip());
            accnt.setAddress(addr);
            accnt.setTelephoneNumber(item.getTelephoneNumber());            
        });
        return Optional.of(accnt);
    }
    
    /**
     * method to get all entries in DB
     * 
     * @return
     */
    
    public Account getAll() {
        Iterable<AccountEntity> accntObj=accountRepository.findAll();
        
        accntObj.forEach(item -> {
            System.out.println("from DB = " + item.getAccountNumber());  
            //TODO: add logic in here
        });
        return null;
    }
    
    /** 
     * Service method to save an entity to Database
     * @param account
     */
    public void save(Account account){
        
        accountRepository.save(convertToEntity(account));
        
    }
    
    private AccountEntity convertToEntity(Account account) {
        
        AccountEntity accountObj=new AccountEntity();
        Address addressVO=account.getAddress();
        accountObj.setAddressLine1(addressVO.getAddressLine1());
        accountObj.setAddressLine2(addressVO.getAddressLine2());
        accountObj.setCity(addressVO.getCity());
        accountObj.setState(addressVO.getState());
        accountObj.setZip(addressVO.getZip());
        accountObj.setTelephoneNumber(account.getTelephoneNumber());
        
        return accountObj;
    }
}
