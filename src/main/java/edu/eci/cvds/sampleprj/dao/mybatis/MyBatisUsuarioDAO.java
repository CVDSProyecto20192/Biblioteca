
package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.UsuarioMapper;
import edu.eci.cvds.samples.entities.Cargo;
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
	public Usuario loadCorreo(String correo) throws PersistenceException {
		Usuario user=usuarioMapper.consultarUsuarioCorreo(correo);
		if(user==null) throw new PersistenceException("Error al consultar cliente "+ correo+
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

	@Override
	public void updateIngresoUsuario(Usuario user) throws PersistenceException {
		try {
			usuarioMapper.actualizarUltimoIngreso(user);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("No fue posible actualizar hora de ingreso de usuario");
		}
		
	}

	@Override
	public void updateBloqueadoUsuario(String carnet, boolean bloqueado) throws PersistenceException {
		try {
			usuarioMapper.actualizarUsuarioBloqueado(carnet,bloqueado);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("No fue posible actualizar estado de usuario");
		}
		
	}

	@Override
	public void loadIdCargoUser(String carnet) throws PersistenceException {
		try {
			usuarioMapper.consultarIdCargoUser(carnet);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("No fue encontrar el cargo del usuario: "+carnet);
		}
		
	}

	@Override
	public void updateCargoUser(Usuario user, Cargo c) throws PersistenceException {
		try {
			usuarioMapper.actualizarCargoUser(user, c);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("No fue posible actualizar cargo del usuario");
		}
		
	}

	@Override
	public boolean loadBloqUser(String carnet) throws PersistenceException {
		try {
			return usuarioMapper.consultarEstadoBloqueado(carnet);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("No fue posible consultar estado del usuario: "+carnet);
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
