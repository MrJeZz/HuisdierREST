package com.durlinger;

import org.springframework.data.repository.CrudRepository;

//public interface gegeven door springboot
//configuratie and connectie met postgresql is gedaan in de application.properties file --> scr/main/resources
public interface HuisdierRepo extends CrudRepository<Huisdier, String>
{

}
