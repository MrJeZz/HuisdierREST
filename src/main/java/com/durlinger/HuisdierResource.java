package com.durlinger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



// resource class functionerend als frontcontroller/dispatcherservlet
//Methods van je service class worden hier gekoppeld aan requests van de client

@RestController
public class HuisdierResource
{
	@Autowired									//Autowired zoekt automatisch in je springcontainer naar betreffende bean
	HuisdierService service;
	
	@GetMapping("huisdieren")				 //mapping wordt gedefinieerd. te callen door de client e.g. in postman 
	public List<Huisdier> getHuisdieren()
	{
		
	return service.getHuisdieren();

	}
	
	@GetMapping("huisdieren/{naam}")
	public Huisdier getHuisdier(@PathVariable("naam") String naam)
	{
		return service.getHuisdier(naam);
	}
	
	@DeleteMapping("huisdieren/{naam}")
	public void deleteHuisdier(@PathVariable ("naam") String naam)
	{
		service.deleteHuisdier(naam);
	}
	
	
	@PostMapping("huisdieren")
	public String createHuisdier(@RequestBody Huisdier huisdier)
	{
		service.saveOrUpdateHuisdier(huisdier);
		
		return huisdier.getNaam();
	}
	
	@PutMapping("huisdieren")
	public Huisdier updateHuisdier(@RequestBody Huisdier huisdier)
	{
		service.saveOrUpdateHuisdier(huisdier);	
		
		return huisdier;
	}
	
	
}





