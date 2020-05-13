package com.amex.accountservice.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.amex.accountservice.service.AccountInfoService;
import com.amex.accountservice.utils.TestUtils;
import com.amex.accountservice.vo.Account;
import com.amex.accountservice.vo.Address;

@SpringBootTest
@ActiveProfiles("test")
@WebMvcTest
public class AccountInfoControllerTest {
    
    @MockBean AccountInfoService mockService;
    @Autowired private MockMvc mockMvc;
    
    /**
     * method tests if get api for account info returns 200 if an object is found
     * @throws Exception
     */
    
    @Test
    public void getSuccess() throws Exception {       
        
        when(mockService.get(1L)).thenReturn(TestUtils.getAccountInfo());
        this.mockMvc.perform(get("/accountInfo")).andDo(print()).andExpect(status().isOk());
        
    }
    
    /**
     * since the output is optional no error is thrown even if data isnt found
     * 
     * @throws Exception
     */
    
    @Test
    public void getEmpty() throws Exception {       
        
        when(mockService.get(1L)).thenReturn(null);
        this.mockMvc.perform(get("/accountInfo")).andDo(print()).andExpect(status().isOk());
        
    }
    
    
    @Test
    public void saveSuccess() throws Exception {     
        
        this.mockMvc.perform(post("/accountInfo")).andDo(print()).andExpect(status().isOk());
        
    }
    
   

}
