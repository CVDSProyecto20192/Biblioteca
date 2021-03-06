package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import org.mybatis.guice.transactional.Transactional;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Tipo;

public interface RecursoDAO {

	public Recurso load(long id) throws PersistenceException;
	
	public List<Recurso> loadAll() throws PersistenceException;
	
	public List<Recurso> loadActivos() throws PersistenceException;
	
	public void addRecurso(Recurso r) throws PersistenceException;
		
	public long loadIdRecurso(String nombre,Tipo t, String ubicacion) throws PersistenceException;
 
	public boolean loadDispRecurso(long id) throws PersistenceException;
	
	@Transactional
	public void updateDispRecurso(long id, boolean b) throws PersistenceException;

	public long loadLastId() throws PersistenceException;

	@Transactional
	public void removeRecurso(long idRecurso) throws PersistenceException;
}
