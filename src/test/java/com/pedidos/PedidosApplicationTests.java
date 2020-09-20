package com.pedidos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pedidos.model.Producto;
import com.pedidos.robot.Client;
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
	void contextLoads() throws ClientProtocolException, IOException {
		/*
		Producto p=new Producto("pc",500);
		Producto pReturn=productoService.create(p);
		assertEquals(pReturn.getDescripcion(), p.getDescripcion());
		assertEquals(pReturn.getPrecio(), p.getPrecio());
		*/
		
		Client c=new Client();
		c.consultar();
	}

}
