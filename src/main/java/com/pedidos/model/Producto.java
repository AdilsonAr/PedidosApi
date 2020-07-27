package com.pedidos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
private int idProducto;
@Column
private String descripcion;
@Column
private double precio;
}
