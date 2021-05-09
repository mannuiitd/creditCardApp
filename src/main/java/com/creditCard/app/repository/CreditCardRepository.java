package com.creditCard.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.creditCard.app.entity.CreditCardEntity;
/**
 * Repository class which extends JPA repository
 * @author manmohan.nayak
 *
 */
public interface CreditCardRepository extends JpaRepository<CreditCardEntity, Long>{
	


}
