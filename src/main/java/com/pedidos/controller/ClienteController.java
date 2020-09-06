package com.pedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedidos.model.Cliente;
import com.pedidos.service.ClienteService;
/*
 * Author:Adilson Arbuez
 * date: 11/08/2020
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	ClienteService cliService;
	
	@GetMapping("/readid")
	public Cliente readid(@RequestParam("id") int id) {
		return cliService.readid(id);
	}
	
	@GetMapping("/readall")
	public List<Cliente> readall(){
		return cliService.readall();
	}
	
	@PostMapping("/create")
	public String create(@RequestBody Cliente cli) {
		Cliente c=cliService.create(cli);
		return "cliente" + c.getIdCliente() + "creado";
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Cliente cli) {
		Cliente c=cliService.update(cli);
		return "cliente" + c.getIdCliente() + "modificado";
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		Cliente cli=cliService.readid(id);
		cliService.delete(cli);
		return "cliente" + cli.getIdCliente() + "eliminado";
	}
	
}
