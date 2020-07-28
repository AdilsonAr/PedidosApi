package com.pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedidos.model.Producto;
import com.pedidos.repository.ProductoRepository;
/*
 * Author:Adilson Arbuez
 * date: 27/07/2020
 */
@Service
public class ProductoService {
	@Autowired
	ProductoRepository productoRepo;
	public Producto create(Producto producto) {
		return productoRepo.save(producto);
	}
	
	public List<Producto> readAll(){
		return productoRepo.findAll();
	}
}
