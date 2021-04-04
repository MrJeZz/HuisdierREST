package com.durlinger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


//Model object class van huisdier. Definiereing van atributen van huisdier en bijbehorende getters en setters
@XmlRootElement
@Entity
@Table(name = "huisdier2")
public class Huisdier 
{
	@Id                                           //naam wordt nu gezien als "flag" voor ieder huisdier object.
	@Column
	@NotEmpty
	@Size(min= 2, max = 50, message= "Naam moet minstens 2 letters bevatten en mag niet bestaan uit meer dan 50 letters")
	@Pattern(regexp="^[A-Za-z]*$",message = "Name can only contain letters from the alphabet") //@Pattern geeft de mogelijkheid om gebruik te maken van regexp, regular expression database
	private String naam;           //Gebruik gemaakt van validation annotations. 
	
	@Column
	@Pattern(regexp="^[1-9][0-9]{0,2}$",message="Leeftijd moet cijfers bevatten, mag niet negatief zijn en moet afgerond zijn op hele jaren")
	@Max(value = 200, message = "200 jaar is de maximale leeftijd")
	//@Min(value = 0, message = "Minimum leeftijd is 0")
	private String leeftijd;
	
	@Column
	@NotEmpty
	@CorrectSpecies
	private String diersoort;
	
	public Huisdier()
	{
		
	}
	
	public Huisdier(String naam, String leeftijd, String diersoort) {
		super();
		this.naam = naam;
		this.leeftijd = leeftijd;
		this.diersoort = diersoort;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getLeeftijd() {
		return leeftijd;
	}
	public void setLeeftijd(String leeftijd) {
		this.leeftijd = leeftijd;
	}
	public String getDiersoort() {
		return diersoort;
	}
	public void setDiersoort(String diersoort) {
		this.diersoort = diersoort;
		
		
		
	}
}