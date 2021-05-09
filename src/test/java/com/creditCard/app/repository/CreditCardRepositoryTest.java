package com.creditCard.app.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.creditCard.app.entity.CreditCardEntity;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
class CreditCardRepositoryTest {

    @Autowired
    private CreditCardRepository repo;

    @Test
    public void getCarList() {
        List<CreditCardEntity> carList = repo.findAll();
         assertNotNull(carList);
    }

    @Test
    public void saveCar() {
    	CreditCardEntity savedCar = repo.save(new CreditCardEntity(1L, 188238329432L));
        assertNotNull(savedCar);
    }

    
}