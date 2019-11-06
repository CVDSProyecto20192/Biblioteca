
package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.UsuarioMapper;
import edu.eci.cvds.samples.entities.Usuario;

public class MyBatisUsuarioDAO implements UsuarioDAO{
	
	@Inject
	private UsuarioMapper usuarioMapper;   

	@Override
	public Usuario load(String carnet) throws PersistenceException {
		Usuario user=usuarioMapper.consultarUsuario(carnet);
		if(user==null) throw new PersistenceException("Error al consultar cliente "+ carnet+
		" - No existe");
		else return user;   
	}

	@Override
	public List<Usuario> loadAll() throws PersistenceException {
		try{
			return usuarioMapper.consultarUsuarios();
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar usuarios", e);
		}  
	}

	@Override
	public void addUsuario(Usuario user) throws PersistenceException {
		try {
			usuarioMapper.insertarUsuario(user);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("No fue posible agregar al usuario");
		}
		
	}

	/*@Override
	public void setPassword(String carnet, String password) throws PersistenceException {
		try {
			usuarioMapper.actualizarPasswordUsuario(carnet, password);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("No fue actualizar la contraseña del usuario");
		}
		
	}*/
	
	

}
