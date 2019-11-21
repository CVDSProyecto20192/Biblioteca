package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Reserva;
import java.util.Date;
public interface ReservaDAO {
	public List<Reserva> loadAll() throws PersistenceException;
	
	public List<Reserva> consultarReservasRecurso(long recursoId) throws PersistenceException;
	
	public Reserva consultarFranja(Date fecha, int hora, int duracion, long recurso) throws PersistenceException;
	
	public void insertarReserva(Reserva reserva) throws PersistenceException;
	
	public List<Date> getFechas(String fecha, String fechaFin,int periodicidad);
	
	public long consultarGrupo() throws PersistenceException;
}
