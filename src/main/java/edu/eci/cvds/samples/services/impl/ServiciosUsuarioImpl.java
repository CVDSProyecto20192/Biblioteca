package edu.eci.cvds.samples.services.impl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.exceptions.ServiciosUsuarioException;
import edu.eci.cvds.sampleprj.dao.CargoDAO;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.samples.entities.Cargo;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ServiciosUsuario;

public class ServiciosUsuarioImpl implements ServiciosUsuario {

	@Inject
	private UsuarioDAO userDAO;
	
	@Inject
	private CargoDAO cargoDAO;
	
	@Override
	public Usuario consultarUsuario(String carnet) throws ServiciosUsuarioException{
		Usuario u=null;
		try {
			u = userDAO.load(carnet);
		} 
		catch (PersistenceException e) {
			throw new ServiciosUsuarioException("Error al consultar el usuario "+carnet, e);
		}
		return u;
	}

	@Override
	public List<Usuario> consultarUsuarios() throws ServiciosUsuarioException{
		List<Usuario> users;
		try {
			users = userDAO.loadAll();
		} 
		catch (PersistenceException e) {
			throw new ServiciosUsuarioException("Error al consultar a los usuarios", e);
		}
		return users;
	}

	@Override
	public void insertarUsuario(Usuario user) throws ServiciosUsuarioException {
		try {
			userDAO.addUsuario(user);
		} 
		catch (PersistenceException e) {
			throw new ServiciosUsuarioException("Error al insertar usuario", e);
		}
		
	}

	@Override
	public void actualizarUltimoIngreso(Usuario user) throws ServiciosUsuarioException {
		try {
			userDAO.updateIngresoUsuario(user);
		} 
		catch (PersistenceException e) {
			throw new ServiciosUsuarioException("Error al actualizar fecha de ingreso de usuario", e);
		}
		
	}

	@Override
	public void actualizarUsuarioBloqueado(String carnet, boolean bloqueado) throws ServiciosUsuarioException {
		try {
			userDAO.updateBloqueadoUsuario(carnet, bloqueado);
		} 
		catch (PersistenceException e) {
			throw new ServiciosUsuarioException("Error al actualizar estado de usuario", e);
		}
		
	}
	
	@Override
	public boolean consultadoEstadoBloqUser(String carnet) throws ServiciosUsuarioException{
		try {
			return userDAO.loadBloqUser(carnet);
		} 
		catch (PersistenceException e) {
			throw new ServiciosUsuarioException("Error al actualizar estado de usuario", e);
		}
	}

	@Override
	public void consultarIdCargoUser(String carnet) throws ServiciosUsuarioException {
		try {
			userDAO.loadIdCargoUser(carnet);
		} 
		catch (PersistenceException e) {
			throw new ServiciosUsuarioException("Error al consultar cargo de usuario: "+carnet, e);
		}
		
	}

	@Override
	public void actualizarCargoUser(Usuario user, Cargo c) throws ServiciosUsuarioException {
		try {
			userDAO.updateCargoUser(user, c);
		} 
		catch (PersistenceException e) {
			throw new ServiciosUsuarioException("Error al actualizar cargo de usuario", e);
		}
		
	}

	@Override
	public Cargo consultarCargo(int idCargo) throws ServiciosUsuarioException {
		try {
			return cargoDAO.loadCargo(idCargo);
		} 
		catch (PersistenceException e) {
			throw new ServiciosUsuarioException("Error al consultar cargo: "+idCargo, e);
		}
	}

	@Override
	public List<Cargo> consultarCargos() throws ServiciosUsuarioException {
		try {
			return cargoDAO.loadCargos();
		} 
		catch (PersistenceException e) {
			throw new ServiciosUsuarioException("Error al listar cargos", e);
		}
	}

	@Override
	public void insertarCargo(Cargo cargo) throws ServiciosUsuarioException {
		try {
			cargoDAO.addCargo(cargo);
		} 
		catch (PersistenceException e) {
			throw new ServiciosUsuarioException("Error al agregar cargo", e);
		}
	}

	@Override
	public int consultarIdCargo(Cargo cargo) throws ServiciosUsuarioException {
		try {
			return cargoDAO.loadIdCargo(cargo);
		} 
		catch (PersistenceException e) {
			throw new ServiciosUsuarioException("Error al consultar id del cargo", e);
		}
	}

}
