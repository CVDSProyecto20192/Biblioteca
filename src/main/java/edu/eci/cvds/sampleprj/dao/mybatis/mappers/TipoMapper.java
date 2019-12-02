package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Tipo;

public interface TipoMapper {

	public Tipo consultarTipo(@Param("id_tipo")int id); 
    
    /**
     * Consultar todos los Tipos
     * @return 
     */
    public List<Tipo> consultarTipos();
    
    public void insertarTipo(@Param("tipo")Tipo tipo);
    
    public int consutarIdTipo(@Param("tipo")Tipo tipo);
}
