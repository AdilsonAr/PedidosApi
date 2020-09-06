package com.pedidos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Entity
@Table(name="DetallePedido")
public class DetallePedido{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idDetallePedido;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="idPedido")
	@JsonBackReference(value="pedido-detalle")
	private Pedido pedido;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="idProducto",nullable = false)
	@JsonBackReference(value="producto-detalle")
	private Producto producto;
	public DetallePedido() {
		super();
	}
	public DetallePedido(Pedido pedido, Producto producto) {
		super();
		this.pedido = pedido;
		this.producto = producto;
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
