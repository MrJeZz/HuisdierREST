package com.durlinger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// service class voor definiering van de methods
// Deze class is de link tussen je REStcontrollerclass en je repository. Repository is vervolgens gelinked aan postgresql

@Service
public class HuisdierService 
{
	@Autowired
	HuisdierRepo repo;
	
	public List<Huisdier> getHuisdieren()
	{	
		List<Huisdier> huisdieren= (List<Huisdier>) repo.findAll();
	
		return huisdieren;	
	}
	
	public Huisdier getHuisdier(String naam)
	{	
		
		return repo.findById(naam).get();	
		
	}
	
	public void saveOrUpdateHuisdier(Huisdier h1)
	{	
		
		repo.save(h1);	
		
	}
	
	public void deleteHuisdier(String naam)
	{	
		
		repo.deleteById(naam);	
		
	}
	
}
