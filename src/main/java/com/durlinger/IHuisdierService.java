package com.durlinger;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IHuisdierService //interface voor paginering en sortering. HuisdierService implementeert deze class
{
	List<Huisdier> findPaginated(int pageNo, int pageSize);
	List<Huisdier> findSortedPaginated(int pageNo, int pageSize);
}

