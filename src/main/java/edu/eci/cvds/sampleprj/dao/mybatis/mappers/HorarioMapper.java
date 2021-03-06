package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Hora;
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
     * Consultar todos los horarios existentes 
     * @return
     */
	public List<Horario> consultarHorarios();
	
	/**
	 * Añadir un nuevo horario
	 * @param h
	 */
    public void insertarHorario(@Param("horario")Horario h, @Param("id_recurso")long r);

    
    /**
     * Añadir una nuva hora
     * @param h
     * @param hora
     */
    public void insertarHora(@Param("horario")Horario h, @Param("hora") Hora hora);
    
    
    
    /**
     * Consultar el id de la hora según el horario
     * @param hora
     * @param horario
     * @return
     */
    public long consultarIdHora(@Param("hora") Hora hora, @Param("horario") Horario horario);

    
    public void actualizarTiempoHora(@Param("id_hora") long idHora, @Param("tiempo_hora") Date hora);
    
    /**
     * Retorna la disponibilidad de la hora dada
     * @param idHora
     * @return
     */
    public boolean consultarDispHora(@Param("id_hora") long idHora);

    /**
     * Actualiza la disponibilidad de la hora
     * @param idHora
     * @param b
     */
	public void actualizarDispHora(@Param("id_hora") long idHora, @Param("disp") boolean b);
	
    
    /**
     * Consultar el id del último horario añadido
     * @return
     */
	public long consultarUltimoId();

	/**
	 * Elimina la hora según su id y el horario al que pertenece
	 * @param idHora Id de hora a eliminar
	 */
	public void eliminarHora(@Param("id_hora")long idHora);

    
}














