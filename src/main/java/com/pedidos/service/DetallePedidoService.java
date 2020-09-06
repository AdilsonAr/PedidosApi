package com.pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedidos.model.DetallePedido;
import com.pedidos.model.Pedido;
import com.pedidos.model.Producto;
import com.pedidos.repository.DetallePedidoRepository;
/*
 * Author:Adilson Arbuez
 */
@Service
public class DetallePedidoService {
	@Autowired
	DetallePedidoRepository detalleRepo;
	
	public DetallePedido readId(int id) {
		return detalleRepo.findById(id).get();
	}
	
	public List<DetallePedido> readProducto(Producto p){
		return detalleRepo.findByProducto(p);
	}
	
	public List<DetallePedido> readPedido(Pedido p){
		return detalleRepo.findByPedido(p);
	}
	
	public DetallePedido create(DetallePedido d) {
		return detalleRepo.save(d);
	}
	
	public DetallePedido update(DetallePedido d) {
		return detalleRepo.save(d);
	}
	
	public void delete(DetallePedido d) {
		detalleRepo.delete(d);
	}
	
}
