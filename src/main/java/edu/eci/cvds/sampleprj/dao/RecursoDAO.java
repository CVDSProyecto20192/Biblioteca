package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Recurso;

public interface RecursoDAO {

	public Recurso load(long id) throws PersistenceException;
	
	public List<Recurso> loadAll() throws PersistenceException;
	
	public List<Recurso> loadDisponibles() throws PersistenceException;
	
	public void addRecurso(Recurso r) throws PersistenceException;
	
	public void bloquearRecurso(Recurso r) throws PersistenceException;
	
}
