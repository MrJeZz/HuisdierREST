package com.durlinger;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler      //validationhandler class die gebruik maakt van controlleradvice annotation gegeven door spring boot hibernate
{
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(							//Behandelt vult en returned de errors omtrent foute parameter invoer
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) 
	{
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError)error).getField();					//Je kunt je errormessage hier customizen. Je zou ook een timestamp in deze body kunnen toevoegen
			String message = error.getDefaultMessage();
			errors.put(fieldName,message);
			
		});

		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);     //In dit geval returnen we een bad reuest error om aan de client te laten zien dat de fout aan de client side zit
	}
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Object> myMessage(CustomException c)
	{
	return new ResponseEntity<>(c.getMessage(), HttpStatus.FORBIDDEN);        //Deze customException wordt aangesproken wanneer Andre wordt opgevraagd aan de client side. 
	}																		//In dit geval returnen we een forbidden error om te laten zien dat de syntax goed is maar dat de resource niet mag worden aangesproken.
}
