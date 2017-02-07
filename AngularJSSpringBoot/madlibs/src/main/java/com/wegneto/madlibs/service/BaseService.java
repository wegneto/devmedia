package com.wegneto.madlibs.service;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wegneto.madlibs.model.BaseModel;

public abstract class BaseService<T extends BaseModel> {
	
	public abstract void delete(Long Id);
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public abstract T get(Long Id);
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public abstract Page<T> list(Integer page);
	
	public abstract T save(T object);

}
