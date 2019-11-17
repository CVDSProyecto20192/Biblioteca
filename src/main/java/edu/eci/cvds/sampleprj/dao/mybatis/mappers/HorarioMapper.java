package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.samples.entities.Horario;

public interface HorarioMapper {

	/**
	 * Consultar el horario en un solo dia
	 * @param id_horario
	 * @param dia
	 * @return
	 */
	public Horario consultarHorarioDia(@Param("id_horario") long id_horario,@Param("dia_horario") String dia); 
    
	/**
	 * Consultar todos el horario de varios dias (semana de un mismo id)
	 * @param id_horario
	 * @return
	 */
	public List<Horario> consultarHorarioDias(@Param("id_horario") long id_horario); 
	
    /**
     * 
     * @return
     */
	public List<Horario> consultarHorarios();
	
    public void insertarHorario(@Param("horario")Horario h);

	public long consultarUltimoId();
	
	public long actualizarHoras(@Param("id_horario") long idHorario, @Param("dia") String dia, @Param("tiempo") List<Date> horas);
    
}
