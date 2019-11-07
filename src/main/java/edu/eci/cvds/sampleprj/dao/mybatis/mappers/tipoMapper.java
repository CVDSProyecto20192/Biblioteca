package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.samples.entities.Tipo;


public interface TipoMapper {
	public Tipo consultarTipo(@Param("id_tipo")int idTipo);
	public void insertarTipo(@Param("tipoR")Tipo t);
}
