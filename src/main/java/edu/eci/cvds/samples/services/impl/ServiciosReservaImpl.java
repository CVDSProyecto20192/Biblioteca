package edu.eci.cvds.samples.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ServiciosReserva;

public class ServiciosReservaImpl implements ServiciosReserva {

	 @Inject
	 private UsuarioDAO userDAO;
	
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

}
