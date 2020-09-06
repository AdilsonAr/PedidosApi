package com.pedidos.service;
/*
 * Author:Adilson Arbuez
 * date: 3/08/2020
 */

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedidos.model.Cliente;
import com.pedidos.model.Pedido;
import com.pedidos.repository.PedidoRepository;
@Service
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepo;
	
	public Pedido readId(int id) {
		return pedidoRepo.findById(id).get();
	}
	
	public List<Pedido> readCliente(Cliente c){
		return pedidoRepo.findByCliente(c);
	}
	
	public List<Pedido> readall(){
		return pedidoRepo.findAll();
	}
	
	public List<Pedido> readFechaRango(LocalDate fecha1,LocalDate fecha2){
		return pedidoRepo.findByFechaAfterAndFechaBefore(fecha1, fecha2);
	}
	
	public List<Pedido> readFecha(LocalDate fecha1){
		return pedidoRepo.findByFechaEquals(fecha1);
	}
	
	public Pedido create(Pedido p) {
		return pedidoRepo.save(p);
	}
	
	public Pedido update(Pedido p) {
		return pedidoRepo.save(p);
	}
	
	public void delete(Pedido p) {
		pedidoRepo.delete(p);
	}
}
