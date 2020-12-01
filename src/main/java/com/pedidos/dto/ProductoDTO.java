package com.pedidos.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pedidos.model.Producto;
@Component
public class ProductoDTO {
	private int idProducto;
	private String descripcion;
	private double precio;  
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)  
	
	private LocalDate adquirido; 
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)  
	private LocalDate caducidad;
	
	public String getDescripcion() { 
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
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
	public ProductoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductoDTO(int idProducto, String descripcion, double precio, LocalDate adquirido, LocalDate caducidad) {
		super();
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.adquirido = adquirido;
		this.caducidad = caducidad;
	}
	
	public ProductoDTO(String descripcion, double precio, LocalDate adquirido, LocalDate caducidad) {
		super();
		this.descripcion = descripcion;
		this.precio = precio;
		this.adquirido = adquirido;
		this.caducidad = caducidad;
	}

	public ProductoDTO toDTO(Producto p) {
		return new ProductoDTO(p.getIdProducto(), p.getDescripcion(), p.getPrecio(), p.getAdquirido(), p.getCaducidad());
	}

	public Producto toModel(ProductoDTO p) {
		return new Producto(p.getDescripcion(), p.getAdquirido(), p.getCaducidad(),p.getPrecio());
	}
	
	public List<ProductoDTO> toDTO(List<Producto> l) {
		List<ProductoDTO> listdto =new ArrayList<ProductoDTO>();
		l.forEach(x->listdto.add(toDTO(x)));
		return listdto;
	}
}
