package com.pedidos.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedidos.model.Cliente;
import com.pedidos.model.Pedido;

/*
 * Author:Adilson Arbuez
 * date: 27/07/2020
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	public List<Pedido> findByCliente(Cliente cliente);
	public List<Pedido> findByFechaAfterAndFechaBefore(LocalDate fecha1, LocalDate fecha2);
	public List<Pedido> findByFechaEquals(LocalDate fecha1);
}
