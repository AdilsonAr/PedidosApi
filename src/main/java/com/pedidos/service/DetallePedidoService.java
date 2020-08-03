package com.pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pedidos.model.DetallePedido;
import com.pedidos.model.Pedido;
import com.pedidos.model.Producto;
import com.pedidos.repository.DetallePedidoRepository;

public class DetallePedidoService {
	@Autowired
	DetallePedidoRepository detalleRepo;
	
	public DetallePedido readId(int id) {
		return detalleRepo.getOne(id);
	}
	
	public List<DetallePedido> readProducto(Producto p){
		return detalleRepo.findByProducto(p);
	}
	
	public List<DetallePedido> readPedido(Pedido p){
		return detalleRepo.findByPedido(p);
	}
}
