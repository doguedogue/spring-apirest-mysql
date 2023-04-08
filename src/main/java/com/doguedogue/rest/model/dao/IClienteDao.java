package com.doguedogue.rest.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doguedogue.rest.model.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long> {

}
