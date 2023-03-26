package com.doguedogue.rest.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.doguedogue.rest.model.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
