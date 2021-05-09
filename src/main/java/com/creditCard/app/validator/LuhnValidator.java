package com.creditCard.app.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
/**
 * Cutsom validator for LuhAlgorithm
 * @author manmohan.nayak
 *
 */
public class LuhnValidator implements ConstraintValidator<Luhn, String> {

	@Override
	public void initialize(Luhn param) {
	}
	/**
	 * Implementation of Luhn Algoriothm
	 * refer https://en.wikipedia.org/wiki/Luhn_algorithm
	 */
	@Override
	public boolean isValid(String str, ConstraintValidatorContext ctx) {
		if (null == str || "".equalsIgnoreCase(str)) {
			return false;
		}
		int i = str.length() - 1;
		int result = 0;
		int temp1 =Character.getNumericValue(str.charAt(i));
		
		while (--i > 0) {
			int temp = Character.getNumericValue(str.charAt(i)) * 2;
			if (temp > 10)
				temp = temp - 9;
			result = result + temp + Character.getNumericValue(str.charAt(--i));
		}

		result = (result * 9) % 10;

		return result == temp1;
	}

}
