package com.mai8mai.dao.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidatorHelper {
	private static ValidatorFactory validatorFactory;
	private static final ThreadLocal<Validator> threadLocal;
	private static final Logger logger;

	static {
		validatorFactory = Validation.buildDefaultValidatorFactory();
		threadLocal = new ThreadLocal<Validator>();
		logger = LoggerFactory.getLogger(ValidatorHelper.class);
	}

	public static Validator getValidator() {
		Validator validator = threadLocal.get();
		if (validator == null) {
			logger.info("getting Validator");
			validator = validatorFactory.getValidator();
			threadLocal.set(validator);
		}
		return validator;
	}
}
