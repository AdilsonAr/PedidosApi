 package com.pedidos.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedidos.dto.PedidoDTO;
import com.pedidos.model.Cliente;
import com.pedidos.model.Pedido;
import com.pedidos.service.ClienteService;
import com.pedidos.service.PedidoService;
/*
 * Author:Adilson Arbuez
 * date: 11/08/2020
 */
@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;
	@Autowired
	ClienteService cliService;
	@Autowired
	PedidoDTO pedidodto;
	
	@GetMapping("/readid")
	public PedidoDTO readid(@RequestParam("id") int id) {
		return pedidodto.toDTO(pedidoService.readId(id));
	} 
	
	@GetMapping("/readcliente")
	public List<PedidoDTO> readcliente(@RequestParam("id") int id) {
		Cliente c=cliService.readid(id);
		return pedidodto.toDTO(pedidoService.readCliente(c));
	}
	
	@GetMapping("/readall")
	public List<PedidoDTO> readall(){
		return pedidodto.toDTO(pedidoService.readall());
	}
	
	@GetMapping("/readfecha")
	public List<PedidoDTO> readfecha(@RequestParam("fecha") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate fecha){
		return pedidodto.toDTO(pedidoService.readFecha(fecha));
	}
	 
	@GetMapping("/readrangofecha")
	public List<PedidoDTO> readfecha(@RequestParam("fecha1") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate fecha1,
			@RequestParam("fecha2") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate fecha2){
		return pedidodto.toDTO(pedidoService.readFechaRango(fecha1, fecha2));
	}
	
	@PostMapping("/create")
	public String create(@RequestParam("fecha") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate fecha, @RequestParam("idCliente") int idCliente) {
		Cliente cli=cliService.readid(idCliente);
		Pedido p=pedidoService.create(pedidodto.toModel(new PedidoDTO(fecha,cli)));
		return "pedido "+p.getIdPedido() + "creado";
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestParam("id") int id) {
	    Pedido p=pedidoService.readId(id);
		pedidoService.delete(p);
		
		return "pedido "+id+" eliminado";
	}
	
	@PutMapping("/update")
	public String update(@RequestParam("fecha") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate fecha, @RequestParam("idCliente") int idCliente) {
		Cliente cli=cliService.readid(idCliente);
		Pedido p=pedidoService.update(pedidodto.toModel(new PedidoDTO(fecha,cli)));
		return "pedido "+p.getIdPedido() + "modificado";
	}
}
