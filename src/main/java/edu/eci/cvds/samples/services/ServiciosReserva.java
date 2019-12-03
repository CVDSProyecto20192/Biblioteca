package edu.eci.cvds.samples.services;

import java.util.Date;
import java.util.List;

import edu.eci.cvds.exceptions.ServiciosReservaException;
import edu.eci.cvds.samples.entities.Hora;
import edu.eci.cvds.samples.entities.Horario;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Reserva;
import edu.eci.cvds.samples.entities.Tipo;
import edu.eci.cvds.samples.entities.Usuario;

public interface ServiciosReserva {

	/***************************************Recursos*********************************/
	
	public Recurso consultarRecurso(long id) throws ServiciosReservaException;
	
	public List<Recurso> consultarRecursos() throws ServiciosReservaException;
	
	public void agregarRecurso(Recurso r) throws ServiciosReservaException;
	
	public long  consultarIdRecurso(String nombre, Tipo tipo, String ubicacion) throws ServiciosReservaException;

	public boolean consultarDisponibilidadRecurso(long id) throws ServiciosReservaException;
	
	public void cambiarDisponibilidadRecurso(long id, boolean b) throws ServiciosReservaException;
	
	public long consultarIdUltimoRecurso() throws ServiciosReservaException;

	public void eliminarRecurso(long i) throws ServiciosReservaException;
	
	/*************************************Tipo Recurso*******************************/

	
	public Tipo consultarTipoRecurso(long id) throws ServiciosReservaException;
	
	public Tipo consultarTipo(int id) throws ServiciosReservaException;
	
	public List<Tipo> consultarTipos() throws ServiciosReservaException;
	
	public void agregarTipo(Tipo r) throws ServiciosReservaException;
	
	public List<Recurso> consultarRecursosActivos() throws ServiciosReservaException;
	
	public int consultarIdTipo(Tipo tipo) throws ServiciosReservaException;
	
	/***********************************Horario Recurso*******************************/

	
	public Horario consultarHorario(long id, String dia) throws ServiciosReservaException;

	public List<Horario> consultarHorarioDias(long id) throws ServiciosReservaException;

	public List<Horario> consultarHorarios() throws ServiciosReservaException;
	
	public void agregarHorario(Horario h, long id_r) throws ServiciosReservaException;
	
	public void agregarHora(Horario h, Hora hs) throws ServiciosReservaException;
	
	public long consultarIdHora(Horario h, Hora hs) throws ServiciosReservaException;
	
	public void cambiarTiempoHora(long idHora, Date hora) throws ServiciosReservaException;
	
	public boolean consultarDispHora(long id) throws ServiciosReservaException;

	public void cambiarDispHora(long id, boolean b) throws ServiciosReservaException;
	
	public long consultarIdUltimoHorario() throws ServiciosReservaException;

	public void eliminarHora(Horario h, long idHora) throws ServiciosReservaException;
	
	
	/***************************************Reservas*********************************/
	
	public Usuario consultarUsuarioCorreo(String usuario)  throws ServiciosReservaException;
	
	public Reserva consultarReserva(long codigo) throws ServiciosReservaException;
	
	public List<Reserva> consultarReservas() throws ServiciosReservaException;
	
	public List<Reserva> consultarReservasRecurso(long recursoId) throws ServiciosReservaException;
	
	public List<Reserva> consultarReservasGrupo(long grupo) throws ServiciosReservaException;
	
	public List<Reserva> consultarReservasUsuario(String usuario) throws ServiciosReservaException;
	
	public Reserva consultarFranja(Date fecha, int hora, int duracion, long recurso) throws ServiciosReservaException; 
	
	public void insertarReserva(String fecha, int hora, int duracion, String usuario, long recurso) throws ServiciosReservaException;
	
	public List<Date> getFechas(String fecha, String fechaFin,int periodicidad);
	
	public void insertarReservaDias(String fecha, int hora, int duracion, String usuario, long recurso, String fechaFin,int periodicidad) throws ServiciosReservaException;

	public long consultarGrupo() throws ServiciosReservaException;
	
	public String calcularSiguiente(Reserva selected) throws ServiciosReservaException;

	public String calcularUltima(Reserva selected) throws ServiciosReservaException;
	
	public List<Reserva> recursosFrecuentes() throws ServiciosReservaException;

	public List<Reserva> frecuenteXHorario() throws ServiciosReservaException;

	public List<Reserva> recursosMasFrecuentes() throws ServiciosReservaException;

	public List<Reserva> masFrecuenteXHorario() throws ServiciosReservaException;

	public List<Reserva> frecuenteXTipo() throws ServiciosReservaException;

	public List<Reserva> recursosFrecuentesXHorario() throws ServiciosReservaException;
	
	public void cancelarReserva(Reserva r) throws ServiciosReservaException;

	public void cancelarReservas(Reserva r) throws ServiciosReservaException;

	public void cancelarReservasHastaFecha(Reserva r, Date f) throws ServiciosReservaException;
	
	public List<Reserva> menosFrecuentesXFecha() throws ServiciosReservaException;

	public List<Reserva> recursosMenosFrecuentesXHorario() throws ServiciosReservaException;

	public List<Reserva> menosFrecuenteXTipo() throws ServiciosReservaException;

	public List<Reserva> horariosMasXFecha() throws ServiciosReservaException;

	public List<Reserva> horarioMasFrecuente() throws ServiciosReservaException;

	public List<Reserva> horariosMasXTipo() throws ServiciosReservaException;

	public List<Reserva> horarioMenosFrecuente() throws ServiciosReservaException;

	public List<Reserva> horariosMenosXFecha() throws ServiciosReservaException;

	public List<Reserva> horariosMenosXTipo() throws ServiciosReservaException;
	
	

}




