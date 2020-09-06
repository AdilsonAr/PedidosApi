package com.pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedidos.model.Cliente;
import com.pedidos.repository.ClienteRepository;
/*
 * Author:Adilson Arbuez
 * date: 27/07/2020
 */
@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepo;
	public Cliente create(Cliente cliente) {
		return clienteRepo.save(cliente);
	}
	
	public Cliente update(Cliente cliente) {
		return clienteRepo.save(cliente);
	}
	
	public Cliente readUser(String user) {
		return clienteRepo.findByUser(user);
	}
	
	public Cliente readid(int id) {
		return clienteRepo.findById(id).get();
	}
	
	public List<Cliente> readall(){
		return clienteRepo.findAll();
	}
	
	public void delete(Cliente c) {
		clienteRepo.delete(c);
	}
}
