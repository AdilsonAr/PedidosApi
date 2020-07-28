package com.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedidos.model.Cliente;
/*
 * Author:Adilson Arbuez
 * date: 27/07/2020
 */
@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{
	public Cliente findByUser(String user);
}
