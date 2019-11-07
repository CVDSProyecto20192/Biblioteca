package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Tipo;

public interface TipoDAO {

	public Tipo load(int id) throws PersistenceException;
	
	public List<Tipo> loadAll() throws PersistenceException;

	public void addTipo(Tipo tipo) throws PersistenceException;
	
}
