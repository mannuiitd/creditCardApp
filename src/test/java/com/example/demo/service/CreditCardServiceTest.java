package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.creditCard.app.entity.CreditCardEntity;
import com.creditCard.app.entity.CreditCardForm;
import com.creditCard.app.repository.CreditCardRepository;
import com.creditCard.app.service.CreditCardService;



public class CreditCardServiceTest {

    @Mock
    CreditCardRepository repo;

    @InjectMocks
    CreditCardService service;

    @Captor
    ArgumentCaptor<CreditCardEntity> type;

   @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllCars() throws Exception{
       //Given
        List<CreditCardEntity> ccList = new ArrayList<>();
        ccList.add(new CreditCardEntity(1L, 188238329432L));
        ccList.add(new  CreditCardEntity(2L, 288238329432L));
        ccList.add(new CreditCardEntity(3L, 388238329432L));

        given(repo.findAll()).willReturn(ccList);

        //When
        List<CreditCardEntity> returnCarList = service.getAllCreditCards();

        //Then
        assertEquals(ccList,returnCarList);
    }

    @Test
    public void saveCreditCard() {
        //Given
    	CreditCardEntity car = new CreditCardEntity(1L, 188238329432L);
       
        given(repo.save(Mockito.any())).willReturn(new CreditCardEntity(1L, 188238329432L));

        //When
        CreditCardEntity savedCar = service.saveCreditCard(new CreditCardForm());
        //CreditCardEntity savedCar = service.saveCreditCard((new CreditCardForm());

        //Then
      //  assertEquals("SUV",savedCar.getType());
        assertNotNull(savedCar);
    }

}