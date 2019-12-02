package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Cargo;

public interface CargoDAO {
	
	public Cargo loadCargo(int idCargo) throws PersistenceException;

	public List<Cargo> loadCargos() throws PersistenceException;
	
	public void addCargo(Cargo cargo) throws PersistenceException;

	public int loadIdCargo(Cargo cargo) throws PersistenceException;
}

