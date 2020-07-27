package com.pedidos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int idCliente;
	@Column
	private String user;
	@Column
	private String nombre;
}
