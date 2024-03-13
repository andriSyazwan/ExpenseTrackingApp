package com.fdmgroup.java2.Expense_App_Spring.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CompanyNotFoundException extends RuntimeException {

	public CompanyNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CompanyNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CompanyNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CompanyNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


}