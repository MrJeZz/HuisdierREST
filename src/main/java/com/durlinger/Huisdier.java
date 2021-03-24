package com.durlinger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


//Model object class van huisdier. Definiereing van atributen van huisdier en bijbehorende getters en setters
@XmlRootElement
@Entity
@Table(name = "huisdier")
public class Huisdier 
{
	@Id                                           //naam wordt nu gezien als "flag" voor ieder huisdier object.
	@Column
	private String naam;
	
	@Column
	private int leeftijd;
	
	@Column
	private String diersoort;
	
	
	
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public int getLeeftijd() {
		return leeftijd;
	}
	public void setLeeftijd(int leeftijd) {
		this.leeftijd = leeftijd;
	}
	public String getDiersoort() {
		return diersoort;
	}
	public void setDiersoort(String diersoort) {
		this.diersoort = diersoort;
		
		
		
	}
}
