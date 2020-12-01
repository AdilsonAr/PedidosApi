package com.pedidos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
/*
 * Author:Adilson Arbuez
 * date: 27/07/2020
 */

//relaciona un pedido con un producto

@Entity
@Table(name="DetallePedido")
public class DetallePedido{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetallePedido;
	private int unidades;
	
	//un grupo de objetos DetallePedido estan relacionados a un pedido
	@ManyToOne
	@JoinColumn(name="idPedido")
	@JsonBackReference(value="pedido-detalle")
	private Pedido pedido;
	
	//un grupo de objetos DetallePedido estan relacionados a un producto
	@ManyToOne
	@JoinColumn(name="idProducto")
	@JsonBackReference(value="producto-detalle")
	private Producto producto;
	
	public DetallePedido() {
		super();
	}
	
	public DetallePedido(int unidades, Pedido pedido, Producto producto) {
		super();
		this.unidades = unidades;
		this.pedido = pedido;
		this.producto = producto;
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
	public int getIdDetallePedido() {
		return idDetallePedido;
	}
	public void setIdDetallePedido(int id) {
		this.idDetallePedido = id;
	}
	
}
