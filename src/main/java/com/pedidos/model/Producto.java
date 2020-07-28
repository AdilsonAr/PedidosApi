package com.pedidos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * Author:Adilson Arbuez
 * date: 27/07/2020
 */
@Entity
@Table(name = "producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idProducto;
	@Column
	private String descripcion;
	@Column
	private double precio;
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
	private List<DetallePedido> detalles;

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(String descripcion, double precio, List<DetallePedido> detalles) {
		super();
		this.descripcion = descripcion;
		this.precio = precio;
		this.detalles = detalles;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public List<DetallePedido> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetallePedido> detalles) {
		this.detalles = detalles;
	}

}
