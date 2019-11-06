package edu.eci.cvds.samples.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.sampleprj.dao.RecursoDAO;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ServiciosReserva;

public class ServiciosReservaImpl implements ServiciosReserva {
	@Inject
	private UsuarioDAO userDAO;
	
	@Inject
	private RecursoDAO recursoDAO;
	 
	@Override
	public Usuario consultarUsuario(String carnet) {
		Usuario u=null;
		try {
			u = userDAO.load(carnet);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public List<Usuario> consultarUsuarios() {
		List<Usuario> users=null
				;
		try {
			users = userDAO.loadAll();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	@Override
	public Recurso consultarRecurso(long id) {
		Recurso r=null;
		try {
			r=recursoDAO.load(id);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public List<Recurso> consultarRecursos() {
		List<Recurso> r=null;
		try {
			r=recursoDAO.loadAll();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public void agregarRecurso(Recurso r) {
		try {
			recursoDAO.addRecurso(r);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
