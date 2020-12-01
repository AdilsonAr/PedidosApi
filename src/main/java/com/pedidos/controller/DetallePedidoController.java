package com.pedidos.controller;

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

import com.pedidos.dto.DetallePedidoDTO;
import com.pedidos.dto.PedidoDTO;
import com.pedidos.dto.ProductoDTO;
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
	@Autowired
	DetallePedidoDTO detalledto;
	@Autowired
	PedidoDTO pedto;
	@Autowired
	ProductoDTO prodto;
	
	@GetMapping("/readpedido")
	public List<DetallePedidoDTO> readpedido(@RequestParam("id") int id) {
		Pedido p=pedidoService.readId(id);
		return detalledto.toDTO(detalleService.readPedido(p));
	}
	
	@GetMapping("readid")
	public DetallePedidoDTO readid(@RequestParam("id") int id) {
		return detalledto.toDTO(detalleService.readId(id));
	}
	
	@GetMapping("/readproducto")
	public List<DetallePedidoDTO> readproducto(@RequestParam("id") int id) {
		Producto p=productoService.readId(id);
		return detalledto.toDTO(detalleService.readProducto(p));
	}
	
	@PostMapping("/create")
	public String create(@RequestParam("idProducto") int idProducto,@RequestParam("idPedido") int idPedido,@RequestParam("unidades") int u) {
		Producto producto=productoService.readId(idProducto);
		Pedido pedido=pedidoService.readId(idPedido);
		DetallePedidoDTO detalle=new DetallePedidoDTO(u,pedto.toDTO(pedido),prodto.toDTO(producto));
		detalleService.create(detalledto.toModel(detalle));
		return "detalle "+detalle.getIdDetallePedido()+"creado";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam("idProducto") int idProducto,@RequestParam("idPedido") int idPedido,@RequestParam("unidades") int u) {
		Producto producto=productoService.readId(idProducto);
		Pedido pedido=pedidoService.readId(idPedido);
		DetallePedidoDTO detalle=new DetallePedidoDTO(u,pedto.toDTO(pedido),prodto.toDTO(producto));
		detalleService.update(detalledto.toModel(detalle));
		return "detalle "+detalle.getIdDetallePedido()+"modificado";
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		DetallePedido detalle=detalleService.readId(id);
		detalleService.delete(detalle);
		return "detalle" + detalle.getIdDetallePedido() + "eliminado";
	}
}
