package edu.eci.cvds.sampleprj.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Horario;

public interface HorarioDAO {

	public Horario load(long id, String dia) throws PersistenceException;
	
	public List<Horario> loadAllDia(long id) throws PersistenceException;
	
	public List<Horario> loadAll() throws PersistenceException;
	
	public void addHorario(Horario h) throws PersistenceException;

	public long loadLastId() throws PersistenceException;
	
	public void updateHoras(long idHorario, String dia, List<Date> horas) throws PersistenceException;
	
}
