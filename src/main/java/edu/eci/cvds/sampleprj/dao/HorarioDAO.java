package edu.eci.cvds.sampleprj.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.exceptions.ServiciosReservaException;
import edu.eci.cvds.samples.entities.Hora;
import edu.eci.cvds.samples.entities.Horario;
import edu.eci.cvds.samples.entities.Recurso;

public interface HorarioDAO {

	public Horario load(long id, String dia) throws PersistenceException;
	
	public List<Horario> loadAllDia(long id) throws PersistenceException;
	
	public List<Horario> loadAll() throws PersistenceException;
	
	public void addHorario(Horario h, long r) throws PersistenceException;
	
	public void addHora(Horario h, Hora hs) throws PersistenceException;

	public long loadIdHora(Hora h, Horario hs) throws PersistenceException;

	public void updateTiempoHora(long idHora, Date hora) throws PersistenceException;
	
	public boolean loadDispHora(long idHora) throws PersistenceException;

	public void updateDispHora(long idHora, boolean b) throws PersistenceException;
	
	public long loadLastId() throws PersistenceException;

	
}
