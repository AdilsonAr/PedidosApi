package com.pedidos.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pedidos.model.Pedido;
import com.pedidos.service.ClienteService;
@Component
public class PedidoDTO{
	@Autowired
	ClienteService cliService;
	private int idPedido;
	private LocalDate fecha;
	private int idCliente;
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
	public int getCliente() {
		return idCliente;
	}
	public void setCliente(int cliente) {
		this.idCliente = cliente;
	}
	public PedidoDTO(int idPedido, LocalDate fecha, int cliente) {
		super();
		this.idPedido = idPedido;
		this.fecha = fecha;
		this.idCliente = cliente;
	}
	
	public PedidoDTO(LocalDate fecha, int cliente) {
		super();
		this.fecha = fecha;
		this.idCliente = cliente;
	}
	
	public PedidoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Pedido toModel(PedidoDTO p) {
		return new Pedido(p.getFecha(),cliService.readid(p.idCliente));
	}
	
	public PedidoDTO toDTO(Pedido p) {
		return new PedidoDTO(p.getIdPedido(),p.getFecha(),p.getCliente().getIdCliente());
	}
	
	public List<PedidoDTO> toDTO(List<Pedido> l) {
		List<PedidoDTO> listdto =new ArrayList<PedidoDTO>();
		l.forEach(x->listdto.add(toDTO(x)));
		return listdto;
	}
	
}
