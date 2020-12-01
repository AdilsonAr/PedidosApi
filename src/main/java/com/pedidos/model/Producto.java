package com.pedidos.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/*
 * Author:Adilson Arbuez
 * date: 27/07/2020
 */
@Entity
@Table(name = "producto")
public class Producto{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	private String descripcion;
	private LocalDate adquirido;
	private LocalDate caducidad;
	private double precio;
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
	@JsonManagedReference(value="producto-detalle")
	private List<DetallePedido> detalles;
	
	public LocalDate getAdquirido() {
		return adquirido;
	}
	
	public void setAdquirido(LocalDate adquirido) {
		this.adquirido = adquirido;
	}

	public LocalDate getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(LocalDate caducidad) {
		this.caducidad = caducidad;
	}

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(String descripcion, LocalDate adquirido, LocalDate caducidad, double precio) {
		super();
		this.descripcion = descripcion;
		this.adquirido = adquirido;
		this.caducidad = caducidad;
		this.precio = precio;
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
