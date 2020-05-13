package com.amex.accountservice.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amex.accountservice.service.AccountInfoService;
import com.amex.accountservice.vo.Account;

/**
 * Exposed APIs for the Account-service
 * @author ajits
 *
 */
@RestController
@RequestMapping(value = "/accountInfo")
public class AccountInfoController {
    
    @Autowired
    private AccountInfoService accountService;

    /**
     * api exposed to query account information using account number
     * @param accountNumber
     * @return
     */
    @ResponseBody
    @GetMapping(value="/{accountNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Account> get(@PathVariable Long accountNumber){
        
               
        return Optional.of(accountService.get(accountNumber));
        
        // TODO add AOP to send back HTTP status 204 if no content is returned.
    }
    
    @GetMapping(value="/",  produces = MediaType.APPLICATION_JSON_VALUE)
    public String get(){
        accountService.getAll(); 
        return "its me";
    }
    
    /**
     * api exposed to persist account information
     * @param accountInfo
     * @return
     */
    @ResponseBody
    @PostMapping(value="/" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody Account account){
        try {
            accountService.save(account);
        }catch(Exception e) {
            //cusotm exceptions should be added, based on the company rule, bubble it and throw it back to the client or catch and report it at this API level
            System.out.println(e);
        }
        
        
    }
}
