package com.amex.accountservice.web;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.amex.accountservice.service.AccountInfoService;
import com.amex.accountservice.utils.TestUtils;


@SpringBootTest
@AutoConfigureMockMvc
public class AccountInfoControllerTest {

    @Mock
    AccountInfoService mockService;
    @Autowired
    private MockMvc mockMvc;

    /**
     * post method tests if get api for account info returns 200 if an object is
     * found
     * 
     * @throws Exception
     */

    @Test
    public void getSuccess() throws Exception {

        when(mockService.get(1L)).thenReturn(Optional.of(TestUtils.getAccountInfo()));
        this.mockMvc.perform(get("/accountInfo/" + 123456)).andDo(print()).andExpect(status().isOk());

    }

    /**
     * since the output is optional no error is thrown even if data isnt found
     * 
     * @throws Exception
     */

    @Test
    public void getEmpty() throws Exception {

        when(mockService.get(1L)).thenReturn(null);
        this.mockMvc.perform(get("/accountInfo/12")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void saveSuccess() throws Exception {

        doNothing().when(mockService).save(TestUtils.getAccountInfo());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/accountInfo").accept(MediaType.APPLICATION_JSON)
                .content(TestUtils.asJsonString(TestUtils.getAccountInfo())).contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

       // assertEquals(HttpStatus.CREATED.value(), response.getStatus());

    }

}
