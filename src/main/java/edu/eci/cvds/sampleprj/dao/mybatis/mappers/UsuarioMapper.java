package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.samples.entities.Usuario;

public interface UsuarioMapper {
	
	public Usuario consultarUsuario(@Param("carnet_usuario")String carnet); 
    
    /**
     * Consultar todos los usuarios
     * @return 
     */
    public List<Usuario> consultarUsuarios();
    
 
    public void insertarUsuario(@Param("usuario")Usuario user);
    
    /**
     * Actualiza el estado de Bloqueado del Usuario
     * @param docu
     * @param estado
     */
	public void actualizarUsuarioBloqueado(@Param("carnet_usuario")String carnet, 
			@Param("bloqueado")boolean bloqueado);
	
	
	public void actualizarPasswordUsuario(@Param("carnet_usuario")String carnet, 
			@Param("password") String password);

	

}
