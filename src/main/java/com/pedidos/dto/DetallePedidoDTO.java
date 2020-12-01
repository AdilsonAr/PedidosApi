package com.pedidos.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pedidos.model.DetallePedido;
@Component
public class DetallePedidoDTO {
	@Autowired
	PedidoDTO pedto;
	@Autowired
	ProductoDTO prodto;
	
	private int idDetallePedido;
	private int unidades;
	private PedidoDTO pedido;
	private ProductoDTO producto;
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
	public PedidoDTO getPedido() {
		return pedido;
	}
	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}
	public ProductoDTO getProducto() {
		return producto;
	}
	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}
	public DetallePedidoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DetallePedidoDTO(int idDetallePedido, int unidades, PedidoDTO pedido, ProductoDTO producto) {
		super();
		this.idDetallePedido = idDetallePedido;
		this.unidades = unidades;
		this.pedido = pedido;
		this.producto = producto;
	}
	
	public DetallePedidoDTO(int unidades, PedidoDTO pedido, ProductoDTO producto) {
		super();
		this.unidades = unidades;
		this.pedido = pedido;
		this.producto = producto;
	}
	
	public DetallePedido toModel(DetallePedidoDTO d) {
		return new DetallePedido(d.getUnidades(),pedto.toModel(d.getPedido()),prodto.toModel(d.getProducto()));
	}
	
	public DetallePedidoDTO toDTO(DetallePedido d) {
		return new DetallePedidoDTO(d.getIdDetallePedido(),d.getUnidades(),pedto.toDTO(d.getPedido()),prodto.toDTO(d.getProducto()));
	}
	
	public List<DetallePedidoDTO> toDTO(List<DetallePedido> l) {
		List<DetallePedidoDTO> listdto =new ArrayList<DetallePedidoDTO>();
		l.forEach(x->listdto.add(toDTO(x)));
		return listdto;
	}
}
