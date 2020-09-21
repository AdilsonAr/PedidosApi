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

import com.fasterxml.jackson.annotation.JsonBackReference;
/*
 * Author:Adilson Arbuez
 * date: 27/07/2020
 */
@Entity
@Table(name="cliente")
public class Cliente{

	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int idCliente;
	@Column
	private String user;
	@Column
	private String nombre;
	@OneToMany(mappedBy="cliente",cascade=CascadeType.ALL)
	@JsonBackReference(value="pedido-cliente")
	private List<Pedido> pedidos;
	public Cliente(String user, String nombre, List<Pedido> pedidos) {
		super();
		this.user = user;
		this.nombre = nombre;
		this.pedidos = pedidos;
	}
	
	public Cliente(String user, String nombre) {
		super();
		this.user = user;
		this.nombre = nombre;
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
