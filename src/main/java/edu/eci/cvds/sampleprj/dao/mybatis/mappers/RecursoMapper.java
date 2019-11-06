package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.samples.entities.Recurso;

public interface RecursoMapper {
	
	public Recurso consultarRecurso(@Param("id_recurso")long idRecurso); 
    
    /**
     * Consultar todos los recursos
     * @return 
     */
    public List<Recurso> consultarRecursos();
	
	public List<Recurso> consultarRecursosDisponibles();

    public void insertarRecurso(@Param("recurso")Recurso r);
	
	public void bloquearRecurso(@Param("recurso")Recurso r);
}
