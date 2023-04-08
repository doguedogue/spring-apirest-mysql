package com.doguedogue.rest.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.doguedogue.rest.model.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);
	
	public Cliente findById (Long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);

}
