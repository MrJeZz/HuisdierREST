package com.durlinger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

// service class voor definiering van de methods
// Deze class is de link tussen je REStcontrollerclass en je repository. Repository is vervolgens gelinked aan postgresql

@Service
public class HuisdierService implements IHuisdierService
{
	@Autowired
	HuisdierRepo repo;
	
	public List<Huisdier> getHuisdieren()
	{	
		List<Huisdier> huisdieren= (List<Huisdier>) repo.findAll();
		
		return huisdieren;	
	}
	
	public <optional> Huisdier getHuisdier(String naam) throws CustomException
	{	
		String n1 = "Andre";
		int k = n1.compareToIgnoreCase(naam);   // Deze returned 0 als de de Strings gelijk zijn
		
		if(k==0)
		{
			throw new CustomException();        // Als k 0 is dan wordt een CustomException gegoooid, gedefinieerd in je custom exception class
		}
		else 
		{
		return repo.findById(naam).get();	    // Als dit niet het geval is dan wordt wordt huisdier gewoon weergegeven
		}
	}
	
	public void saveOrUpdateHuisdier(Huisdier h1)
	{	
		
		repo.save(h1);	
		
	}
	
	public void deleteHuisdier(String naam)
	{	
		
		repo.deleteById(naam);	
		
	}

	@Override
	public List<Huisdier> findPaginated(int pageNo, int pageSize) //paginering service zonder sort, gedefinieerd in interface IHuisDierService
	{
		
		Pageable paging = PageRequest.of(pageNo,pageSize);
		Page<Huisdier> pagedResult = repo.findAll(paging);
		return pagedResult.toList();
		
	}

	@Override
	public List<Huisdier> findSortedPaginated(int pageNo, int pageSize) //paginering service met sortering, gedefinieerd in interface IHuisDierService
	{
		
		Pageable paging = PageRequest.of(pageNo,pageSize, Sort.by("naam").ascending());
		Page<Huisdier> pagedResult = repo.findAll(paging);
		return pagedResult.toList();
	}
	
}
