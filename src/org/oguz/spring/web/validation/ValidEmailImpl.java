package org.oguz.spring.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.EmailValidator;

public class ValidEmailImpl implements ConstraintValidator<ValidEmail, String>
{

	private int min;

	@Override
	public void initialize(ValidEmail constraintAnnotation)
	{
		this.min = constraintAnnotation.min();

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context)
	{
		if (value.length() < min)
		{
			return false;
		}

		if (!EmailValidator.getInstance(true).isValid(value))
		{
			return false;
		}
		return true;
	}

}
