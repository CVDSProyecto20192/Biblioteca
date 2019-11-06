package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Cargo;

public interface CargoDAO {
	
	void addCargo(Cargo cargo) throws PersistenceException;

}
