package com.pedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedidos.model.Producto;
import com.pedidos.service.ProductoService;
/*
 * Author:Adilson Arbuez
 * date: 10/08/2020
 */
@RestController
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	 ProductoService productoService;
	
	@PostMapping("/create")
	public String create( @RequestBody Producto p) {
		Producto producto= productoService.create(p);
		return "producto "+producto.getIdProducto() + "creado";
	}
	
	@PutMapping("/update")
	public String update( @RequestBody Producto p) {
		Producto producto= productoService.update(p);
		return "producto "+producto.getIdProducto() + "modificado";
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestBody int id) {
		Producto p=productoService.readId(id);
		productoService.delete(p);
		return "producto "+p.getIdProducto() + "eliminado";
	}
	
	@GetMapping("/readall")
	public List<Producto> readall(){
		return productoService.readAll();
	}
	
	@GetMapping("/readid")
	public Producto readid(@RequestParam("id") int id){
		return productoService.readId(id);
	}
}
