package com.creditCard.app.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.creditCard.app.entity.CreditCardEntity;
import com.creditCard.app.entity.CreditCardForm;
import com.creditCard.app.service.CreditCardService;
import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CreditCardProcessingController.class)
@ActiveProfiles("test")
public class CreditCardProcessingControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CreditCardService creditCardService;

    @Test
    public void getCreditCard_Details() throws Exception{
		List<CreditCardEntity>  list = new ArrayList<>();
		given(creditCardService.getAllCreditCards()).willReturn(list);

        mockMvc.perform(get("/api/v1/creditCard/getCreditCardDetails"))
                .andExpect(status().isOk());;
    }

    @Test
    public void saveCreditCard() throws Exception{
        CreditCardEntity crediCardEntity = new CreditCardEntity(1l, 2324234234l);
        
        CreditCardForm creditCard = new CreditCardForm();
		creditCard.setName("MANMOHAN");
		creditCard.setCardNumber("2324234234");
		creditCard.setLimit("234727455");
		
        given(creditCardService.saveCreditCard(creditCard)).willReturn(crediCardEntity);

        mockMvc.perform(post("/cars/")
                .content(asJsonString(new CreditCardEntity(1l, 2324234234l)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isMap())
                .andDo(print());
    }

  

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
