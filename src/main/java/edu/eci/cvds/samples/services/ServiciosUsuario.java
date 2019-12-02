package edu.eci.cvds.samples.services;

import java.util.List;

import edu.eci.cvds.exceptions.ServiciosUsuarioException;
import edu.eci.cvds.samples.entities.Cargo;
import edu.eci.cvds.samples.entities.Usuario;

public interface ServiciosUsuario {

	/***************************************Usuarios*********************************/
	
	public Usuario consultarUsuario(String carnet) throws ServiciosUsuarioException;

	public List<Usuario>consultarUsuarios() throws ServiciosUsuarioException;
	
	public void insertarUsuario(Usuario user) throws ServiciosUsuarioException;
	
	public void actualizarUltimoIngreso(Usuario user) throws ServiciosUsuarioException;
	
	public void actualizarUsuarioBloqueado(String carnet, boolean bloqueado) throws ServiciosUsuarioException;
	
	public void consultarIdCargoUser(String carnet) throws ServiciosUsuarioException;
	
	public void actualizarCargoUser(Usuario user, Cargo c) throws ServiciosUsuarioException;
	
	public boolean consultadoEstadoBloqUser(String carnet) throws ServiciosUsuarioException;

	/****************************************Cargos**********************************/
	
	public Cargo consultarCargo(int idCargo) throws ServiciosUsuarioException;
	
	public List<Cargo> consultarCargos() throws ServiciosUsuarioException;
	
	public void insertarCargo(Cargo cargo) throws ServiciosUsuarioException;

	public int consultarIdCargo(Cargo cargo) throws ServiciosUsuarioException;
	
}






