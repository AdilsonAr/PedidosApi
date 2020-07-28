package com.pedidos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pedidos.model.Producto;
import com.pedidos.service.ProductoService;
/*
 * Author:Adilson Arbuez
 * date: 27/07/2020
 */
@SpringBootTest
class PedidosApplicationTests {
	@Autowired
	ProductoService productoService;

	@Test
	void contextLoads() {
		Producto p=new Producto("pc",500);
		Producto pReturn=productoService.create(p);
		assertEquals(pReturn.getDescripcion(), p.getDescripcion());
		assertEquals(pReturn.getPrecio(), p.getPrecio());
	}

}
