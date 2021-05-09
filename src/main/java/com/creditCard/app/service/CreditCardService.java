package com.creditCard.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditCard.app.entity.CreditCardEntity;
import com.creditCard.app.entity.CreditCardForm;
import com.creditCard.app.repository.CreditCardRepository;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author manmohan.nayak
 *
 */
@Service
public class CreditCardService {
	
	@Autowired
	protected   CreditCardRepository repository;
	
	/**
	 * Send data to repository to save 
	 * @param creditCard
	 * @return
	 */
	public CreditCardEntity saveCreditCard(CreditCardForm   creditCard) {
		CreditCardEntity crediCardEntity = new CreditCardEntity();
		
		crediCardEntity.setName(creditCard.getName());
		long limit =  creditCard.getLimit() != null ?Long.valueOf(creditCard.getLimit()):0;
		crediCardEntity.setLimit(limit);
		long cardNumber = creditCard.getCardNumber() != null ? Long.valueOf(creditCard.getCardNumber()):0;
		crediCardEntity.setCardNumber(cardNumber);
		
		return repository.save(crediCardEntity) ;
	}
	
	/**
	 * return all the credit cards from repository
	 * @return
	 */
	public List<CreditCardEntity> getAllCreditCards(){
		return repository.findAll();
	}

}
