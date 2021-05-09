package com.creditCard.app.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.creditCard.app.validator.Luhn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author manmohan.nayak
 * Input form class
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreditCardForm {
	
	@NotBlank(message = "Please provide a Name")
	private String name;
	
	@Pattern(regexp="[0-9]*", message = "Credit Card Number should be numeric")
	@NotBlank(message = "Please provide a valid Credit Card Number")
	@Size(min=5, max=19, message = "Please provide a Credit Card Number upto 19 Digit")
	@Luhn(message = "Please provide a valid Credit Card Number upto 19 Digit")
	private String cardNumber;
	
	@Pattern(regexp="[0-9]*", message = "Limit should be numeric")
	private String limit;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	

}
