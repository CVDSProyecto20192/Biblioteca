package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Reserva;

public interface ReservaDAO {
	public List<Reserva> loadAll() throws PersistenceException;
}
