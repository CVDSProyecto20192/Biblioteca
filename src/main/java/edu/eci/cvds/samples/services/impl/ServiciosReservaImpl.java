package edu.eci.cvds.samples.services.impl;

import java.sql.Date;
import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.exceptions.ServiciosReservaException;
import edu.eci.cvds.sampleprj.dao.HorarioDAO;
import edu.eci.cvds.sampleprj.dao.RecursoDAO;
import edu.eci.cvds.sampleprj.dao.TipoDAO;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.samples.entities.Hora;
import edu.eci.cvds.samples.entities.Horario;
import edu.eci.cvds.samples.entities.Recurso;
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


}



