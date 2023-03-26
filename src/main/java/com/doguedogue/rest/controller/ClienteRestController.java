package com.doguedogue.rest.controller;

//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.doguedogue.rest.model.entity.Cliente;
import com.doguedogue.rest.model.service.IClienteService;

@CrossOrigin (origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private IClienteService clienteService;

	@GetMapping ("/clientes")
	public List<Cliente> index(){
		return clienteService.findAll();
	}
	
	@GetMapping ("/clientes/{id}")
	public Cliente show(@PathVariable Long id){
		return clienteService.findById(id);
	}
	
	@PostMapping ("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cliente) {
//		cliente.setCreatedAt(new Date());
		return clienteService.save(cliente);
	}
	
	@PutMapping ("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {

		Cliente clienteBD = clienteService.findById(id);
		
		if (clienteBD == null) {
			return null;
		}
		
		clienteBD.setNombre(cliente.getNombre());
		clienteBD.setApellido(cliente.getApellido());
		clienteBD.setEmail(cliente.getEmail());
		
		return clienteService.save(clienteBD);
	}
	
	@DeleteMapping ("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		clienteService.delete(id);
	}
	
}
