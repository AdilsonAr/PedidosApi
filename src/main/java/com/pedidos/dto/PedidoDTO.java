package com.pedidos.dto;

import java.time.LocalDate;

import com.pedidos.model.Cliente;
import com.pedidos.model.Pedido;

public class PedidoDTO{
	private int idPedido;
	private LocalDate fecha;
	private Cliente cliente;
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public PedidoDTO(int idPedido, LocalDate fecha, Cliente cliente) {
		super();
		this.idPedido = idPedido;
		this.fecha = fecha;
		this.cliente = cliente;
	}
	public PedidoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Pedido toModel(PedidoDTO p) {
		return new Pedido(p.getFecha(),p.cliente);
	}
	
	public PedidoDTO toDTO(Pedido p) {
		return new PedidoDTO(p.getIdPedido(),p.getFecha(),p.getCliente());
	}
	
}
