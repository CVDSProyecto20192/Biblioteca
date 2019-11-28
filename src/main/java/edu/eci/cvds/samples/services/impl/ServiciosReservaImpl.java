package edu.eci.cvds.samples.services.impl;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.exceptions.ServiciosReservaException;
import edu.eci.cvds.sampleprj.dao.HorarioDAO;
import edu.eci.cvds.sampleprj.dao.RecursoDAO;
import edu.eci.cvds.sampleprj.dao.ReservaDAO;
import edu.eci.cvds.sampleprj.dao.TipoDAO;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.samples.entities.Hora;
import edu.eci.cvds.samples.entities.Horario;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Reserva;
import edu.eci.cvds.samples.entities.Tipo;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ServiciosReserva;

public class ServiciosReservaImpl implements ServiciosReserva {
	@Inject
	private UsuarioDAO userDAO;
	
	@Inject
	private RecursoDAO recursoDAO;
	
	@Inject
	private TipoDAO tipoDAO;
	
	@Inject
	private HorarioDAO horarioDAO;
	 
	@Inject
	private ReservaDAO reservaDAO;
	
	@Override
	public Usuario consultarUsuario(String carnet) throws ServiciosReservaException{
		Usuario u=null;
		try {
			u = userDAO.load(carnet);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar el usuario "+carnet, e);
		}
		return u;
	}

	@Override
	public List<Usuario> consultarUsuarios() throws ServiciosReservaException{
		List<Usuario> users;
		try {
			users = userDAO.loadAll();
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar a los usuarios", e);
		}
		return users;
	}
	
	@Override
	public Recurso consultarRecurso(long id) throws ServiciosReservaException{
		try {
			return recursoDAO.load(id);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar el recurso "+id, e);
		}
	}

	@Override
	public List<Recurso> consultarRecursos() throws ServiciosReservaException{
		try {
			return recursoDAO.loadAll();
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar los recursos", e);
		}
	}

	@Override
	public void agregarRecurso(Recurso r) throws ServiciosReservaException{
		try {
			recursoDAO.addRecurso(r);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al agregrar el recurso", e);
		}
		
	}

	@Override
	public Tipo consultarTipoRecurso(long id) throws ServiciosReservaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tipo consultarTipo(int id) throws ServiciosReservaException {
		Tipo t;
		try {
			t=tipoDAO.load(id);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar el tipo", e);
		}
		return t;
	}

	@Override
	public List<Tipo> consultarTipos() throws ServiciosReservaException {
		List<Tipo> tl;
		try {
			tl=tipoDAO.loadAll();
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar los tipos", e);
		}
		return tl;
	}

	@Override
	public void agregarTipo(Tipo t) throws ServiciosReservaException {
		try {
			tipoDAO.addTipo(t);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al agregar el tipo", e);
		}
		
	}

	@Override
	public long consultarIdRecurso(String nombre, Tipo t, String ubicacion) throws ServiciosReservaException {
		try {
			return recursoDAO.loadIdRecurso(nombre, t, ubicacion);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar el id del recurso", e);
		}
	}

	@Override
	public boolean consultarDisponibilidadRecurso(long id) throws ServiciosReservaException {
		try {
			return recursoDAO.loadDispRecurso(id);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar disponibilidad del recurso "+id, e);
		}
	}

	@Override
	public void cambiarDisponibilidadRecurso(long id, boolean b) throws ServiciosReservaException {
		try {
			Recurso r = consultarRecurso(id);
			recursoDAO.updateDispRecurso(id, b);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al actualizar disponibilidad del recurso "+id, e);
		}
		
	}

	@Override
	public Horario consultarHorario(long idHorario, String dia) throws ServiciosReservaException {
		try {
			return horarioDAO.load(idHorario, dia);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar horario: "+idHorario+" "+dia, e);
		}
	}

	@Override
	public List<Horario> consultarHorarioDias(long idHorario) throws ServiciosReservaException {
		try {
			return horarioDAO.loadAllDia(idHorario);
		} 
		catch (PersistenceException e) {
			System.out.println("consul "+idHorario);
			throw new ServiciosReservaException("Error al consultar horarios: "+idHorario, e);
		}
	}

	@Override
	public List<Horario> consultarHorarios() throws ServiciosReservaException {
		try {
			return horarioDAO.loadAll();
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar horarios", e);
		}
	}

	@Override
	public void agregarHorario(Horario h, long r) throws ServiciosReservaException {
		try {
			horarioDAO.addHorario(h,r);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al agregar el horario", e);
		}
	}
	
	@Override
	public void agregarHora(Horario h, Hora hs) throws ServiciosReservaException {
		try {
			horarioDAO.addHora(h, hs);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al agregar la hora", e);
		}
		
	}
	
	
	@Override
	public long consultarIdHora(Horario h, Hora hs) throws ServiciosReservaException {
		try {
			return horarioDAO.loadIdHora(hs, h);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar id de la hora", e);
		}
	}
	
	
	@Override
	public void cambiarTiempoHora(long idHora, Date hora) throws ServiciosReservaException{
		try {
			horarioDAO.updateTiempoHora(idHora,hora);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar id de la hora", e);
		}
		
	}
	
	
	@Override
	public boolean consultarDispHora(long idHora) throws ServiciosReservaException {
		try {
			return horarioDAO.loadDispHora(idHora);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar disponibilidad de la hora", e);
		}
	}

	
	@Override
	public void cambiarDispHora(long idHora, boolean b) throws ServiciosReservaException {
		try {
			horarioDAO.updateDispHora(idHora, b);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al cambiar disponibilidad de la hora", e);
		}
	}

	
	
	@Override
	public long consultarIdUltimoRecurso() throws ServiciosReservaException {
		try {
			long idRec=recursoDAO.loadLastId();
			return idRec;
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar id del ultimo recurso", e);
		}
	}
	
	
	@Override
	public long consultarIdUltimoHorario() throws ServiciosReservaException {
		try {
			long idHor=horarioDAO.loadLastId();
			return idHor;
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar id del ultimo horario", e);
		}
	}

	
	@Override
	public void eliminarRecurso(long idRecurso) throws ServiciosReservaException {
		try {
			recursoDAO.removeRecurso(idRecurso);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al eliminar el recurso " + idRecurso, e);
		}
		
	}
	
	
	@Override
	public void eliminarHora(Horario h,long idHora) throws ServiciosReservaException {
		try {
			horarioDAO.removeHora(h,idHora);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al eliminar la hora " + idHora, e);
		}
		
	}
	
	
	@Override
	public Reserva consultarFranja(Date fecha, int hora, int duracion,long recurso) throws ServiciosReservaException {
		Reserva r = null;
		try {
			r = reservaDAO.consultarFranja(fecha, hora, duracion,recurso);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar franja", e);
		}
		return r;
	}
	
	@Override
	public void insertarReserva(String fecha, int hora, int duracion, String usuario, long recurso) throws ServiciosReservaException{
		try {
			Usuario u = consultarUsuario(usuario);
			Recurso r = consultarRecurso(recurso);
			Reserva res = new Reserva((long) 2, fecha, hora, duracion, u, r, (long) 0, null);
			if (consultarFranja(res.getFecha(), res.getHora(), res.getDuracion(),recurso) == null){
				reservaDAO.insertarReserva(res);
			}
			else{
				throw new ServiciosReservaException("Imposible hacer esta reserva, porque el horario no esta disponible");
			}
		} 
		catch (ServiciosReservaException e) {
			throw new ServiciosReservaException("Error al insertar reserva", e);
		}
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al insertar reserva", e);
		}
	}
	
	@Override
	public List<Date> getFechas(String fecha, String fechaFin,int periodicidad){
		 List<Date> fechas = reservaDAO.getFechas(fecha, fechaFin, periodicidad);
		 return fechas;
	}
	
	@Override
	public void insertarReservaDias(String fecha, int hora, int duracion, String usuario, long recurso, String fechaFin,int periodicidad) throws ServiciosReservaException{
		try {
			List<Date> fechas = getFechas(fecha, fechaFin, periodicidad);
			boolean flag = true;
			for(int i=0; i<fechas.size();i++){
				Date f = fechas.get(i);
				if (consultarFranja(f, hora, duracion,recurso) != null){
					flag=false;
				}
			}
	
			if(flag){
				Usuario u = consultarUsuario(usuario);
				Recurso r = consultarRecurso(recurso);
				long grupo = consultarGrupo();
				for(int i=0; i<fechas.size();i++){
					Date f = fechas.get(i);
					Reserva res = new Reserva((long) 0, f, hora, duracion, u, r, grupo, null);
					reservaDAO.insertarReserva(res);
				}
			}else{
				throw new ServiciosReservaException("Imposible hacer esta reserva, porque el horario no esta disponible");
			}
			
		}catch (ServiciosReservaException e) {
			throw new ServiciosReservaException("Error al insertar reserva", e);
		}catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al insertar reserva", e);
		}
	
	}
	
	@Override
	public long consultarGrupo() throws ServiciosReservaException {
		try{
			return reservaDAO.consultarGrupo();
		}
		catch(PersistenceException e){
			throw new ServiciosReservaException("Error al consultar id del grupo", e);
		}  
	}

	@Override
	public List<Recurso> consultarRecursosActivos() throws ServiciosReservaException{
		List<Recurso> r=null;
		try {
			r=recursoDAO.loadActivos();
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar los recursos activos", e);
		}
		return r;
	}

	@Override
	public List<Reserva> consultarReservas() throws ServiciosReservaException {
		List<Reserva> tl;
		try {
			tl=reservaDAO.loadAll();
			
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar las reservas", e);
		}
		return tl;
	}
	
	@Override
	public List<Reserva> consultarReservasRecurso(long recursoId) throws ServiciosReservaException {
		List<Reserva> reservas;
		try {
			reservas=reservaDAO.consultarReservasRecurso(recursoId);
			
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar las reservas del recurso con Id: " + recursoId , e);
		}
		return reservas;
	}
	
	@Override
	public List<Reserva> consultarReservasGrupo(long grupo) throws ServiciosReservaException {
		List<Reserva> reservas;
		try {
			reservas=reservaDAO.consultarReservasGrupo(grupo);
			
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar las reservas del grupo: " + grupo, e);
		}
		return reservas;
	}

}


