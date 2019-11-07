package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Tipo;

public interface TipoDAO {
	
	public Tipo load(int id) throws PersistenceException;

	void addTipo(Tipo t) throws PersistenceException;
}
