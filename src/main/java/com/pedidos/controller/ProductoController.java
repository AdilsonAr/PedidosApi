package com.pedidos.controller;

import java.util.ArrayList;
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

import com.pedidos.dto.ProductoDTO;
import com.pedidos.model.DetallePedido;
import com.pedidos.model.Pedido;
import com.pedidos.model.Producto;
import com.pedidos.service.PedidoService;
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
	@Autowired
	PedidoService pedidoService;
	@Autowired
	ProductoDTO prodto;
	
	@PostMapping("/create")
	public String create(@RequestBody ProductoDTO p) {
		Producto producto= productoService.create(prodto.toModel(p));
		return "producto "+producto.getIdProducto() + "creado";
	}
	
	@PutMapping("/update")
	public String update(@RequestBody ProductoDTO p) {
		Producto producto= productoService.update(prodto.toModel(p));
		return "producto "+producto.getIdProducto() + "modificado";
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestParam int id) {
		Producto p=productoService.readId(id);
		productoService.delete(p);
		return "producto "+p.getIdProducto() + "eliminado";
	}
	
	@GetMapping("/readall")
	public List<ProductoDTO> readall(){
		return prodto.toDTO(productoService.readAll());
	}
	
	@GetMapping("/readid")
	public ProductoDTO readid(@RequestParam("id") int id){
		return prodto.toDTO(productoService.readId(id));
	}
	
	//los productos incluidos en un pedido
		@GetMapping("/readproductopedido")
		public List<ProductoDTO> readproductopedido(@RequestParam("id") int id) {
			List<Producto> ls=new ArrayList<Producto>();
			
			Pedido p=pedidoService.readId(id);
			List<DetallePedido> l= p.getDetalles();
			 
			l.forEach(x-> ls.add(x.getProducto()));
			return prodto.toDTO(ls);
		}
}
