package edu.eci.cvds.samples.services;

import java.util.List;

import edu.eci.cvds.exceptions.ServiciosReservaException;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Tipo;
import edu.eci.cvds.samples.entities.Usuario;

public interface ServiciosReserva {

	public Usuario consultarUsuario(String carnet) throws ServiciosReservaException;

	public List<Usuario>consultarUsuarios() throws ServiciosReservaException;

	public Recurso consultarRecurso(long id) throws ServiciosReservaException;
	
	public List<Recurso> consultarRecursos() throws ServiciosReservaException;
	
	public void agregarRecurso(Recurso r) throws ServiciosReservaException;
	
	public Tipo consultarTipoRecurso(long id) throws ServiciosReservaException;
	
	public Tipo consultarTipo(int id) throws ServiciosReservaException;
	
	public List<Tipo> consultarTipos() throws ServiciosReservaException;
	
	public void agregarTipo(Tipo r) throws ServiciosReservaException;


}
