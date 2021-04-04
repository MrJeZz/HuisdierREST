package com.durlinger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

//public interface gegeven door springboot
//configuratie and connectie met postgresql is gedaan in de application.properties file --> scr/main/resources
public interface HuisdierRepo extends PagingAndSortingRepository<Huisdier, String> //PagingAndSorting is een uitbreiding op de CRUDrepository
{

}
