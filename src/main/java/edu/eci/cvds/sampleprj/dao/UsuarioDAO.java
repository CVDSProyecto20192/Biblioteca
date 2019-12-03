package edu.eci.cvds.sampleprj.dao;


import java.util.List;

import org.mybatis.guice.transactional.Transactional;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Cargo;
import edu.eci.cvds.samples.entities.Usuario;


public interface UsuarioDAO {

	public Usuario load(String carnet) throws PersistenceException;
	
	public Usuario loadCorreo(String correo) throws PersistenceException;
	
	public List<Usuario> loadAll() throws PersistenceException;

	@Transactional
	public void addUsuario(Usuario user) throws PersistenceException;
	
	@Transactional
	public void updateIngresoUsuario(Usuario user) throws PersistenceException;
	
	@Transactional
	public void updateBloqueadoUsuario(String carnet, boolean bloqueado) throws PersistenceException;
	
	public void loadIdCargoUser(String carnet) throws PersistenceException;
	
	@Transactional
	public void updateCargoUser(Usuario user, Cargo c) throws PersistenceException;
	
	public boolean loadBloqUser(String carnet) throws PersistenceException;
	
	
}
