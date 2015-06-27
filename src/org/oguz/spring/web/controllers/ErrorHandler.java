package org.oguz.spring.web.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler
{
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException ex, Model model)
	{
		ex.printStackTrace();

		return "error";
	}

	@ExceptionHandler(AccessDeniedException.class)
	public String handleAccessDeniedException(AccessDeniedException ex)
	{

		return "denied";
	}

}
