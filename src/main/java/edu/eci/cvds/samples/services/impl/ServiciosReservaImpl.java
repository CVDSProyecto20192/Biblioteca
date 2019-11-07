package edu.eci.cvds.samples.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.exceptions.ServiciosReservaException;
import edu.eci.cvds.sampleprj.dao.RecursoDAO;
import edu.eci.cvds.sampleprj.dao.TipoDAO;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Tipo;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ServiciosReserva;

public class ServiciosReservaImpl implements ServiciosReserva {
	@Inject
	private UsuarioDAO userDAO;
	
	@Inject
	private RecursoDAO recursoDAO;
	
	@Inject
	private TipoDAO tipoDAO;
	 
	@Override
	public Usuario consultarUsuario(String carnet) throws ServiciosReservaException{
		Usuario u=null;
		try {
			u = userDAO.load(carnet);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar el usuario "+carnet, e);
		}
		return u;
	}

	@Override
	public List<Usuario> consultarUsuarios() throws ServiciosReservaException{
		List<Usuario> users;
		try {
			users = userDAO.loadAll();
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar a los usuarios", e);
		}
		return users;
	}
	
	@Override
	public Recurso consultarRecurso(long id) throws ServiciosReservaException{
		Recurso r=null;
		try {
			r=recursoDAO.load(id);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar el recurso "+id, e);
		}
		return r;
	}

	@Override
	public List<Recurso> consultarRecursos() throws ServiciosReservaException{
		List<Recurso> r=null;
		try {
			r=recursoDAO.loadAll();
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar los recursos", e);
		}
		return r;
	}

	@Override
	public void agregarRecurso(Recurso r) throws ServiciosReservaException{
		try {
			recursoDAO.addRecurso(r);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al agregrar el recurso", e);
		}
		
	}

	@Override
	public Tipo consultarTipoRecurso(long id) throws ServiciosReservaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tipo consultarTipo(int id) throws ServiciosReservaException {
		Tipo t;
		try {
			t=tipoDAO.load(id);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar el tipo", e);
		}
		return t;
	}

	@Override
	public List<Tipo> consultarTipos() throws ServiciosReservaException {
		List<Tipo> tl;
		try {
			tl=tipoDAO.loadAll();
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar los tipos", e);
		}
		return tl;
	}

	@Override
	public void agregarTipo(Tipo t) throws ServiciosReservaException {
		try {
			tipoDAO.addTipo(t);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al agregar el tipo", e);
		}
		
	}

}
