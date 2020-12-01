package com.pedidos.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pedidos.model.Cliente;
@Component
public class ClienteDTO {
	private int idCliente;
	private String user;
	private String nombre;
	private String telefono;
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public ClienteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClienteDTO(int idCliente, String user, String nombre, String telefono) {
		super();
		this.idCliente = idCliente;
		this.user = user;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	public Cliente toModel(ClienteDTO c) {
		return new Cliente(c.getUser(),c.getNombre(),c.getTelefono());
	}
	
	public ClienteDTO toDTO(Cliente c) {
		return new ClienteDTO(c.getIdCliente(),c.getUser(),c.getNombre(),c.getTelefono());
	}
	
	public List<ClienteDTO> toDTO(List<Cliente> l) {
		List<ClienteDTO> listdto =new ArrayList<ClienteDTO>();
		l.forEach(x->listdto.add(toDTO(x)));
		return listdto;
	}
}
