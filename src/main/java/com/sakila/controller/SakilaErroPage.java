package com.sakila.controller;

import java.util.Date;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.sakila.entity.ErrorDetails;

@RestController
public class SakilaErroPage implements ErrorController {
	
	private static final String PATH_STRING="/error";
	
	@RequestMapping(value="/error")
	public ResponseEntity<ErrorDetails> errorPage(WebRequest request) {
		ErrorDetails errorDetails=new ErrorDetails(new Date(), "Resource Not Found",request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails,new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH_STRING;
	}

}
