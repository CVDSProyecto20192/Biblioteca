package edu.eci.cvds.sampleprj.dao;

import java.util.Date;
import java.util.List;

import org.mybatis.guice.transactional.Transactional;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Hora;
import edu.eci.cvds.samples.entities.Horario;

public interface HorarioDAO {

	public Horario load(long id, String dia) throws PersistenceException;
	
	public List<Horario> loadAllDia(long id) throws PersistenceException;
	
	public List<Horario> loadAll() throws PersistenceException;
	
	public void addHorario(Horario h, long r) throws PersistenceException;
	
	public void addHora(Horario h, Hora hs) throws PersistenceException;

	public long loadIdHora(Hora h, Horario hs) throws PersistenceException;
	
	@Transactional
	public void updateTiempoHora(long idHora, Date hora) throws PersistenceException;
	
	public boolean loadDispHora(long idHora) throws PersistenceException;
	
	@Transactional
	public void updateDispHora(long idHora, boolean b) throws PersistenceException;
	
	public long loadLastId() throws PersistenceException;
	
	@Transactional
	public void removeHora(Horario h, long idHora) throws PersistenceException;

	
}
