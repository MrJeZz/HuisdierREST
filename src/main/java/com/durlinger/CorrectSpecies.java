package com.durlinger;



import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)								//Hij wordt gebruikt voor en field type, in dit geval "diersoort" component van "Huisdier"
@Constraint(validatedBy = DiersoortValidater.class)		//Logic van deze annotation word gedfinieerd in de DiersoortValidator class
public @interface CorrectSpecies 						//Hier wordt een nieuwe annotation gemaakt met de naam correct species
{
	

	    String message() default "Diersoort hoort niet in deze database";  

	    Class<?>[] groups() default {};

	    Class<? extends Payload>[] payload() default {};

	
}
