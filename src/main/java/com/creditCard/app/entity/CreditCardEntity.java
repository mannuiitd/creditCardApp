package com.creditCard.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Entity class for DB
 * @author manmohan.nayak
 *
 */
@Entity
@Table(name = "CREDIT_CARD")
public class CreditCardEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long creditCard_Id;

	private String name;
	private Long cardNumber;
	
	@Column(name="LIMIT_BALANCE")
	private Long limit;
	
	
	public CreditCardEntity() {
		super();
	}

	public CreditCardEntity(Long creditCard_Id, Long cardNumber) {
		super();
		this.creditCard_Id = creditCard_Id;
		this.cardNumber = cardNumber;
	}

	private Long balance;

	
	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Long getLimit() {
		return limit;
	}

	public void setLimit(Long limit) {
		this.limit = limit;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public Long getCreditCard_Id() {
		return creditCard_Id;
	}

	public void setCreditCard_Id(Long creditCard_Id) {
		this.creditCard_Id = creditCard_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
