package com.pedidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedidos.model.DetallePedido;
import com.pedidos.model.Pedido;
import com.pedidos.model.Producto;
/*
 * Author:Adilson Arbuez
 * date: 27/07/2020
 */
@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer>{
	public List<DetallePedido> findByProducto(Producto p);
	public List<DetallePedido> findByPedido(Pedido p);
}
