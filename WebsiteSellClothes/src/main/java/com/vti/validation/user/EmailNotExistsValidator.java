package com.vti.validation.user;

import com.vti.service.implement.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailNotExistsValidator implements ConstraintValidator<EmailNotExists, String> {

	@Autowired
	private IUserService service;

	@SuppressWarnings("deprecation")
	@Override
	public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

		if (StringUtils.isEmpty(email)) {
			return true;
		}

		return !service.existsUserByEmail(email);
	}
}