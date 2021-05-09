
package com.creditCard.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditCard.app.entity.CreditCardEntity;
import com.creditCard.app.entity.CreditCardForm;
import com.creditCard.app.service.CreditCardService;

/**
 * @author manmohan.nayak
 * REST class for Credit Card Operation
 */

@RestController
@RequestMapping("/api/v1/creditCard")
public class CreditCardProcessingController {
	
	@Autowired
	private CreditCardService creditCardService;
	
	

	/**
	 *  To Fetch all the credit card details
	 * @return
	 */
	@GetMapping("/getCreditCardDetails")
	public ResponseEntity<List<CreditCardEntity>> findAll() {
		//return 	ResponseEntity.status(OK).body(creditCardService.getAllCreditCard());
		return new ResponseEntity<>( creditCardService.getAllCreditCards(),HttpStatus.OK);
	}

	/**
	 *  Validate Credit card information and save to DB.  
	 * @param crediCardForm
	 * @return
	 */
	@PostMapping("/addCrediCard")
	public ResponseEntity<CreditCardEntity> saveCreditCard(@Valid @RequestBody CreditCardForm crediCardForm) {
		return new ResponseEntity<>(creditCardService.saveCreditCard(crediCardForm),HttpStatus.CREATED);
	}
	
}
