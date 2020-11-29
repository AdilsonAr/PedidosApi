package com.pedidos.dto;

import java.util.ArrayList;
import java.util.List;

import com.pedidos.model.DetallePedido;
import com.pedidos.model.Pedido;
import com.pedidos.model.Producto;

public class DetallePedidoDTO {
	private int idDetallePedido;
	private int unidades;
	private Pedido pedido;
	private Producto producto;
	public int getIdDetallePedido() {
		return idDetallePedido;
	}
	public void setIdDetallePedido(int idDetallePedido) {
		this.idDetallePedido = idDetallePedido;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public DetallePedidoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DetallePedidoDTO(int idDetallePedido, int unidades, Pedido pedido, Producto producto) {
		super();
		this.idDetallePedido = idDetallePedido;
		this.unidades = unidades;
		this.pedido = pedido;
		this.producto = producto;
	}
	
	public DetallePedidoDTO(int unidades, Pedido pedido, Producto producto) {
		super();
		this.unidades = unidades;
		this.pedido = pedido;
		this.producto = producto;
	}
	
	public DetallePedido toModel(DetallePedidoDTO d) {
		return new DetallePedido(d.getUnidades(),d.getPedido(),d.getProducto());
	}
	
	public DetallePedidoDTO toDTO(DetallePedido d) {
		return new DetallePedidoDTO(d.getIdDetallePedido(),d.getUnidades(),d.getPedido(),d.getProducto());
	}
	
	public List<DetallePedidoDTO> toDTO(List<DetallePedido> l) {
		List<DetallePedidoDTO> listdto =new ArrayList<DetallePedidoDTO>();
		l.forEach(x->listdto.add(toDTO(x)));
		return listdto;
	}
}
