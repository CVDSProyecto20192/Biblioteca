package edu.eci.cvds.sampleprj.dao;


import java.util.List;

import org.mybatis.guice.transactional.Transactional;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Usuario;


public interface UsuarioDAO {

	public Usuario load(String carnet) throws PersistenceException;
	
	public List<Usuario> loadAll() throws PersistenceException;

	/*public void addUsuario(Usuario user) throws PersistenceException;
	
	@Transactional
	public void setPassword(String carnet, String password) throws PersistenceException;*/
	
}
