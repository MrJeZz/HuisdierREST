package com.durlinger;

public class CustomException extends Exception
{
	public CustomException()            // Een simpele custom exception voor Andre, genereert een simpele message op het moment dat de class wordt gecalled
	{
		super("Andre is geheim!");
	}
}
