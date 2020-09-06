package com.pedidos.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
/*
 * Author:Adilson Arbuez
 * date: 27/07/2020
 */
@Entity
@Table(name="pedido")
public class Pedido{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idPedido;
	@Column
	private LocalDate fecha;
	@OneToMany(mappedBy = "pedido",cascade=CascadeType.ALL)
	@JsonManagedReference(value="pedido-detalle")
	private List<DetallePedido> detalles;
	@ManyToOne(fetch=FetchType.LAZY,optional = false)
	@JoinColumn(name="idCliente",nullable = false)
	@JsonBackReference(value="pedido-cliente")
	private Cliente cliente;
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pedido(LocalDate fecha, List<DetallePedido> detalles, Cliente cliente) {
		super();
		this.fecha = fecha;
		this.detalles = detalles;
		this.cliente = cliente;
	}
	
	public Pedido(LocalDate fecha, Cliente cliente) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
	}
	
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
	public List<DetallePedido> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetallePedido> detalles) {
		this.detalles = detalles;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
