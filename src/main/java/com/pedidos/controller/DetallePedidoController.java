package com.pedidos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/*
 * Author:Adilson Arbuez
 * date: 11/08/2020
 */

import com.pedidos.model.DetallePedido;
import com.pedidos.model.Pedido;
import com.pedidos.model.Producto;
import com.pedidos.service.DetallePedidoService;
import com.pedidos.service.PedidoService;
import com.pedidos.service.ProductoService;
@RestController
@RequestMapping("/detalle")
public class DetallePedidoController {
	@Autowired
	DetallePedidoService detalleService;
	@Autowired
	PedidoService pedidoService;
	@Autowired
	ProductoService productoService;
	
	@GetMapping("/readpedido")
	public List<DetallePedido> readpedido(@RequestParam("id") int id) {
		Pedido p=pedidoService.readId(id);
		return detalleService.readPedido(p);
	}
	
	@GetMapping("readid")
	public DetallePedido readid(@RequestParam("id") int id) {
		return detalleService.readId(id);
	}
	
	@GetMapping("/readproducto")
	public List<DetallePedido> readproducto(@RequestParam("id") int id) {
		Producto p=productoService.readId(id);
		return detalleService.readProducto(p);
	}

	//los productos incluidos en un pedido
	@GetMapping("/readproductopedido")
	public List<Producto> readproductopedido(@RequestParam("id") int id) {
		List<Producto> ls=new ArrayList<Producto>();
		
		Pedido p=pedidoService.readId(id);
		List<DetallePedido> l= p.getDetalles();
		 
		l.forEach(x-> ls.add(x.getProducto()));
		return ls;
	}
	
	@PostMapping("/create")
	public String create(@RequestParam("idProducto") int idProducto,@RequestParam("idPedido") int idPedido) {
		Producto producto=productoService.readId(idProducto);
		Pedido pedido=pedidoService.readId(idPedido);
		DetallePedido detalle=new DetallePedido(pedido,producto);
		detalleService.create(detalle);
		return "detalle "+detalle.getIdDetallePedido()+"creado";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam("idProducto") int idProducto,@RequestParam("idPedido") int idPedido) {
		Producto producto=productoService.readId(idProducto);
		Pedido pedido=pedidoService.readId(idPedido);
		DetallePedido detalle=new DetallePedido(pedido,producto);
		detalleService.update(detalle);
		return "detalle "+detalle.getIdDetallePedido()+"modificado";
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		DetallePedido detalle=detalleService.readId(id);
		detalleService.delete(detalle);
		return "detalle" + detalle.getIdDetallePedido() + "eliminado";
	}
}
