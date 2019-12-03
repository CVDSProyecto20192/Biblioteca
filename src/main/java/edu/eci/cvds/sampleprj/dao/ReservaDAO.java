package edu.eci.cvds.sampleprj.dao;

import java.util.Date;
import java.util.List;

import org.mybatis.guice.transactional.Transactional;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Reserva;
public interface ReservaDAO {
	public List<Reserva> loadAll() throws PersistenceException;
	
	public List<Reserva> consultarReservasRecurso(long recursoId) throws PersistenceException;
	
	public List<Reserva> consultarReservasGrupo(long grupo) throws PersistenceException;

	public List<Reserva> consultarReservasUsuario(String usuario) throws PersistenceException;

	public List<Reserva> consultarReservasUsuarioNoActivas(String usuario) throws PersistenceException;
	
	public Reserva consultarFranja(Date fecha, int hora, int duracion, long recurso) throws PersistenceException;
	
	public void insertarReserva(Reserva reserva) throws PersistenceException;
	
	public List<Date> getFechas(String fecha, String fechaFin,int periodicidad);
	
	public long consultarGrupo() throws PersistenceException;

	public Reserva ConsultarReserva(long codigo) throws PersistenceException;

	public List<Reserva> recursosFrecuentes() throws PersistenceException;

	public List<Reserva> frecuenteXHorario() throws PersistenceException;

	public List<Reserva> recursosMasFrecuentes() throws PersistenceException;

	public List<Reserva> masFrecuenteXHorario() throws PersistenceException;

	public List<Reserva> frecuenteXTipo() throws PersistenceException;

	public List<Reserva> recursosFrecuentesXHorario() throws PersistenceException;

	public List<Reserva> menosFrecuentesXFecha() throws PersistenceException;

	public List<Reserva> recursosMenosFrecuentesXHorario() throws PersistenceException;

	public List<Reserva> menosFrecuenteXTipo() throws PersistenceException;

	public List<Reserva> horariosMasXFecha() throws PersistenceException;

	public List<Reserva> horarioMasFrecuente() throws PersistenceException;

	public List<Reserva> horariosMasXTipo() throws PersistenceException;

	public List<Reserva> horarioMenosFrecuente() throws PersistenceException;

	public List<Reserva> horariosMenosXFecha() throws PersistenceException;

	public List<Reserva> horariosMenosXTipo() throws PersistenceException;

	@Transactional
	public void cancelarReserva(Reserva r) throws PersistenceException;
	
	@Transactional
	public void cancelarReservas(Reserva r) throws PersistenceException;
	
	@Transactional
	public void cancelarReservasHastaFecha(Reserva r, Date f) throws PersistenceException;

	public List<Reserva> graficoMasUsados() throws PersistenceException;

	public List<Reserva> graficarMenosUsados() throws PersistenceException;
}