package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Cargo;
import edu.eci.cvds.samples.entities.Usuario;

public interface UsuarioMapper {
	
	/**
	 * Consulta la información de un usuario de acuerdo a su carner
	 * @param carnet Identificador carnet del usuario
	 * @return Usuario con el carnet dado
	 */
	public Usuario consultarUsuario(@Param("carnet_usuario")String carnet); 
    
	public Usuario consultarUsuarioCorreo(@Param("correo")String carnet); 
	
    /**
     * Consultar todos los usuarios
     * @return Lista con todos los usuarios existentes
     */
    public List<Usuario> consultarUsuarios();
    
    
    /**
     * Consulta si el Usuario está bloqueado (t) o no (f)
     * @param carnet Carnet del usuario
     * @return t o f dependiendo del estado
     */
    public boolean consultarEstadoBloqueado(@Param("carnet_usuario")String carnet);
    
    /**
     * Inserta un nuevo usuario
     * @param user Usuario nuevo
     */
    public void insertarUsuario(@Param("usuario")Usuario user);
    
    
    /**
     * Actualiza la hora de ingreso del usuario dado
     * @param user Usuario al que se le quiere actualizar la hora de ingreso
     */
    public void actualizarUltimoIngreso(@Param("usuario")Usuario user);
    
    
    /**
     * Actualiza el estado de Bloqueado del Usuario
     * @param docu
     * @param estado
     */
	public void actualizarUsuarioBloqueado(@Param("carnet_usuario")String carnet, 
			@Param("bloq") boolean b);
	
	/**
	 * Consulta el cargo de un usuario dado
	 * @param user
	 */
	public void consultarIdCargoUser(@Param("carnet_usuario")String carnet);
	
	
	/**
	 * Actualiza el cargo de un usuario
	 * @param user Usuario al que se quiere actualizar
	 * @param c Cargo del usuario
	 */
	public void actualizarCargoUser(@Param("usuario")Usuario user, @Param("cargo")Cargo c);
	
	/**
	public void actualizarPasswordUsuario(@Param("carnet_usuario")String carnet, 
			@Param("password") String password);
	*/
	


}
