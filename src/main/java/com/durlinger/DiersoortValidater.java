package com.durlinger;


import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class DiersoortValidater  implements ConstraintValidator<CorrectSpecies, String>  //Nodig om je custom annotation te definieren
{
	List<String> diersoorten = Arrays.asList("Hond", "Kat", "Olifant", "Gifkikker");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) 
    {
    	
    	return diersoorten.contains(value);
    	
    }
}
