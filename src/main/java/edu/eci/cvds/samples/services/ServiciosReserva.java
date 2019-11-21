package edu.eci.cvds.samples.services;

import java.util.List;
import edu.eci.cvds.exceptions.ServiciosReservaException;
import edu.eci.cvds.samples.entities.Hora;
import edu.eci.cvds.samples.entities.Horario;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Tipo;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.entities.Reserva;
import java.util.Date;
public interface ServiciosReserva {

	public Usuario consultarUsuario(String carnet) throws ServiciosReservaException;

	public List<Usuario>consultarUsuarios() throws ServiciosReservaException;

	public Recurso consultarRecurso(long id) throws ServiciosReservaException;
	
	public List<Recurso> consultarRecursos() throws ServiciosReservaException;
	
	public void agregarRecurso(Recurso r) throws ServiciosReservaException;
	
	public Tipo consultarTipoRecurso(long id) throws ServiciosReservaException;
	
	public Tipo consultarTipo(int id) throws ServiciosReservaException;
	
	public List<Tipo> consultarTipos() throws ServiciosReservaException;
	
	public void agregarTipo(Tipo r) throws ServiciosReservaException;
	
	public long  consultarIdRecurso(String nombre, Tipo tipo, String ubicacion) throws ServiciosReservaException;

	public boolean consultarDisponibilidadRecurso(long id) throws ServiciosReservaException;
	
	public void cambiarDisponibilidadRecurso(long id, boolean b) throws ServiciosReservaException;

	public Horario consultarHorario(long id, String dia) throws ServiciosReservaException;

	public List<Horario> consultarHorarioDias(long id) throws ServiciosReservaException;

	public List<Horario> consultarHorarios() throws ServiciosReservaException;
	
	public void agregarHorario(Horario h, long id_r) throws ServiciosReservaException;
	
	public void agregarHora(Horario h, Hora hs) throws ServiciosReservaException;
	
	public long consultarIdHora(Horario h, Hora hs) throws ServiciosReservaException;
		
	long consultarIdUltimoRecurso() throws ServiciosReservaException;

	long consultarIdUltimoHorario() throws ServiciosReservaException;
	

	public List<Recurso> consultarRecursosActivos() throws ServiciosReservaException;
	
	public List<Reserva> consultarReservas() throws ServiciosReservaException;
	
	public List<Reserva> consultarReservasRecurso(long recursoId) throws ServiciosReservaException;
	
	public Reserva consultarFranja(Date fecha, int hora, int duracion, long recurso) throws ServiciosReservaException; 
	
	public void insertarReserva(String fecha, int hora, int duracion, String usuario, long recurso) throws ServiciosReservaException;
	
	public List<Date> getFechas(String fecha, String fechaFin,int periodicidad);
	
	public void insertarReservaDias(String fecha, int hora, int duracion, String usuario, long recurso, String fechaFin,int periodicidad) throws ServiciosReservaException;

	public long consultarGrupo() throws ServiciosReservaException;
}




