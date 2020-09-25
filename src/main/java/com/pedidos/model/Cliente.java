package com.pedidos.model;

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
@Table(name="cliente")
public class Cliente{

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int idCliente;
	private String user;
	private String nombre;
	private String telefono;
	
	@OneToMany(mappedBy="cliente",cascade=CascadeType.ALL)
	@JsonManagedReference(value="pedido-cliente")
	private List<Pedido> pedidos;
	
	public Cliente(String user, String nombre, String telefono, List<Pedido> pedidos) {
		super();
		this.user = user;
		this.nombre = nombre;
		this.telefono = telefono;
		this.pedidos = pedidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Cliente(String user, String nombre,String telefono) {
		super();
		this.user = user;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	public Cliente() {
		super();
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}
