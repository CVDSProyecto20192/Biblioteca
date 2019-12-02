package edu.eci.cvds.sampleprj.dao;

import java.util.Date;
import java.util.List;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Reserva;
public interface ReservaDAO {
	public List<Reserva> loadAll() throws PersistenceException;
	
	public List<Reserva> consultarReservasRecurso(long recursoId) throws PersistenceException;
	
	public List<Reserva> consultarReservasGrupo(long grupo) throws PersistenceException;

	public List<Reserva> consultarReservasUsuario(String usuario) throws PersistenceException;
	
	public Reserva consultarFranja(Date fecha, int hora, int duracion, long recurso) throws PersistenceException;
	
	public void insertarReserva(Reserva reserva) throws PersistenceException;
	
	public List<Date> getFechas(String fecha, String fechaFin,int periodicidad);
	
	public long consultarGrupo() throws PersistenceException;

	public Reserva ConsultarReserva(long codigo) throws PersistenceException;

	public List<Reserva> recursosFrecuentes() throws PersistenceException;

	public List<Reserva> frecuenteXHorario() throws PersistenceException;

	public List<Reserva> recursosMasFrecuentes() throws PersistenceException;

	public List<Reserva> masFrecuenteXHorario() throws PersistenceException;

	public List<Reserva> tiposMasUsados() throws PersistenceException;

	public List<Reserva> recursosFrecuentesXHorario() throws PersistenceException;
}