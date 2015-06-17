package org.oguz.spring.web.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DatabaseErrorHandler
{
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException ex, Model model){
		
	
		return "error";
	}

}
