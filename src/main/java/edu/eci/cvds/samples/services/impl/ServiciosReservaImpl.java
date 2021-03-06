package edu.eci.cvds.samples.services.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	public int consultarIdTipo(Tipo tipo) throws ServiciosReservaException {
		try {
			return tipoDAO.loadIdTipo(tipo);
			
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar el id del tipo", e);
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
			@SuppressWarnings("unused")
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
		SimpleDateFormat formato = new SimpleDateFormat("E");
		try {
			Usuario u = consultarUsuario(usuario);
			Recurso r = consultarRecurso(recurso);
			Reserva res = new Reserva((long) 2, fecha, hora, duracion, u, r, (long) 0, null);
			if ((consultarFranja(res.getFecha(), res.getHora(), res.getDuracion(),recurso) == null) && !(formato.format(res.getFecha()).equals("Sun")) && !(formato.format(res.getFecha()).equals("Sat") && hora + duracion > 1300 ) && !(formato.format(res.getFecha()).equals("dom.")) && !(formato.format(res.getFecha()).equals("sáb.") && hora + duracion > 1300 )){
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
		SimpleDateFormat formato = new SimpleDateFormat("E");
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
					if (!(formato.format(f).equals("Sun")) && !(formato.format(f).equals("Sat") && hora + duracion > 1300 ) && !(formato.format(f).equals("dom.")) && !(formato.format(f).equals("sáb.") && hora + duracion > 1300)){
						Reserva res = new Reserva((long) 0, f, hora, duracion, u, r, grupo, null);
						reservaDAO.insertarReserva(res);
					}
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
	public Reserva consultarReserva(long codigo) throws ServiciosReservaException{
		Reserva res;
		try {
			res=reservaDAO.ConsultarReserva(codigo);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar las reserva", e);
		}
		return res;

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
	
	@Override
	public List<Reserva> consultarReservasUsuario(String usuario) throws ServiciosReservaException {
		List<Reserva> reservas;
		try {
			reservas=reservaDAO.consultarReservasUsuario(usuario);

		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar las reservas del usuario: " + usuario, e);
		}
		return reservas;
	}

	@Override
	public List<Reserva> consultarReservasUsuarioNoActivas(String usuario) throws ServiciosReservaException {
		List<Reserva> reservas;
		try {
			reservas=reservaDAO.consultarReservasUsuarioNoActivas(usuario);

		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar las reservas del usuario: " + usuario, e);
		}
		return reservas;
	}
	
	@Override
	public String calcularSiguiente(Reserva selected) throws ServiciosReservaException{
		Reserva resSig=null;
		String siguiente=null;
		try {
			List<Reserva> grupito= consultarReservasGrupo(selected.getGrupo());
			boolean flag = false;
			Reserva r = null;
			for(int i=0;i<grupito.size();i++){
				r=grupito.get(i);
				if(flag==true){
					flag=false;
					resSig=r;
				}
				if(r.getCodigo()==selected.getCodigo()){
					flag=true;
				}	
			}
			if(resSig!=null){
				Date fecha1 = resSig.getFechaI();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				siguiente = sdf.format(fecha1);
			}else{
				siguiente = "Esta es la última.";
			}
			
		}catch (ServiciosReservaException e) {
			throw new ServiciosReservaException("Error al consultar la siguiente", e);
		}
		
		return siguiente;
	}
	@Override
	public String calcularUltima(Reserva selected) throws ServiciosReservaException{
		String ultima = null;
		try {
			List<Reserva> grupito = consultarReservasGrupo(selected.getGrupo());
			Reserva ult=grupito.get(grupito.size()-1);
			if(ult.getCodigo()!=selected.getCodigo()){
				Date fecha1 = ult.getFechaI();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				ultima = sdf.format(fecha1);
			}else{
				ultima = "Esta es la última";
			}
		}catch (ServiciosReservaException e) {
			throw new ServiciosReservaException("Error al consultar la ultima", e);
		}
		
		return ultima;
	}
	
	@Override
	public List<Reserva> recursosFrecuentes() throws ServiciosReservaException {

		try {
			return reservaDAO.recursosFrecuentes();
		} catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar las reservas", e);
		}
	}

	@Override
	public List<Reserva> frecuenteXHorario() throws ServiciosReservaException {

		try{
			return reservaDAO.frecuenteXHorario();
		}catch (PersistenceException e) {
			// TODO Auto-generated catch block
			throw new ServiciosReservaException("Error al consultar las reservas", e);
		}
	}

	@Override
	public List<Reserva> recursosMasFrecuentes() throws ServiciosReservaException {
		try {
			return reservaDAO.recursosMasFrecuentes();
		} catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar las reservas", e);
		}
	}

	@Override
	public List<Reserva> masFrecuenteXHorario() throws ServiciosReservaException {
		try {
			return reservaDAO.masFrecuenteXHorario();
		} catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar las reservas", e);
		}
	}
	
	@Override
	public List<Reserva> frecuenteXTipo() throws ServiciosReservaException {
		try {
			return reservaDAO.frecuenteXTipo();
		} catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar las reservas", e);
		}
	}

	@Override
	public List<Reserva> recursosFrecuentesXHorario() throws ServiciosReservaException {
		try {
			return reservaDAO.recursosFrecuentesXHorario();
		} catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar las reservas", e);
		}
	}

	@Override
	public Usuario consultarUsuarioCorreo(String correo) throws ServiciosReservaException{
		Usuario u=null;
		try {
			u = userDAO.loadCorreo(correo);
		} 
		catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar el usuario "+correo, e);
		}
		return u;
	}

	@Override
	public List<Reserva> menosFrecuentesXFecha() throws ServiciosReservaException {
		try {
			return reservaDAO.menosFrecuentesXFecha();
		} catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar las reservas", e);
		}
	}

	@Override
	public List<Reserva> recursosMenosFrecuentesXHorario() throws ServiciosReservaException {
		try {
			return reservaDAO.recursosMenosFrecuentesXHorario();
		} catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar las reservas", e);
		}
	}

	@Override
	public List<Reserva> menosFrecuenteXTipo() throws ServiciosReservaException {
		try {
			return reservaDAO.menosFrecuenteXTipo();
		} catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar las reservas", e);
		}
	}

	@Override
	public List<Reserva> horariosMasXFecha() throws ServiciosReservaException {
		try {
			return reservaDAO.horariosMasXFecha();
		} catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar las reservas", e);
		}
	}

	@Override
	public List<Reserva> horarioMasFrecuente() throws ServiciosReservaException {
		try {
			return reservaDAO.horarioMasFrecuente();
		} catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar las reservas", e);
		}
	}

	@Override
	public List<Reserva> horariosMasXTipo() throws ServiciosReservaException {
		try {
			return reservaDAO.horariosMasXTipo();
		} catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar las reservas", e);
		}
	}

	@Override
	public List<Reserva> horarioMenosFrecuente() throws ServiciosReservaException {
		try {
			return reservaDAO.horarioMenosFrecuente();
		} catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar las reservas", e);
		}
	}

	@Override
	public List<Reserva> horariosMenosXFecha() throws ServiciosReservaException {
		try {
			return reservaDAO.horariosMenosXFecha();
		} catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar las reservas", e);
		}
	}

	@Override
	public List<Reserva> horariosMenosXTipo() throws ServiciosReservaException {
		try {
			return reservaDAO.horariosMenosXTipo();
		} catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar las reservas", e);
		}
	}
	
	@Override
	public void cancelarReserva(Reserva r) throws ServiciosReservaException {
		try{
			reservaDAO.cancelarReserva(r);
		} catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al cancelar reserva" , e);
		}	
	}
	
	@Override
	public void cancelarReservas(Reserva r) throws ServiciosReservaException{
		try{
			reservaDAO.cancelarReserva(r);
		} catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al cancelar reserva" , e);
		}	
	}
	
	@Override
	public void cancelarReservasHastaFecha(Reserva r, Date f) throws ServiciosReservaException{
		try{
			reservaDAO.cancelarReservasHastaFecha(r, f);
		} catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al cancelar reserva" , e);
		}	
	}

	@Override
	public List<Reserva> consultarReservasCanceladas(List<Reserva> noActivas) {
		List<Reserva> canceladas = new ArrayList<Reserva>();
		Date hoy = new Date();
		for(Reserva res : noActivas){
			if(res.getFechaF().compareTo(hoy)>0){
				canceladas.add(res);
			}
		}

		return canceladas;
	}

	@Override
	public List<Reserva> consultarReservasPasadas(List<Reserva> noActivas) {
		List<Reserva> pasadas = new ArrayList<Reserva>();
		Date hoy = new Date();
		for(Reserva res : noActivas){
			if(res.getFechaF().compareTo(hoy)<0){
				pasadas.add(res);
			}
		}
		return pasadas;
	}
	
	public List<Reserva> graficoMasUsados() throws ServiciosReservaException {
		try{
			return reservaDAO.graficoMasUsados();
		} catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar reserva" , e);
		}	
	}

	@Override
	public List<Reserva> graficarMenosUsados() throws ServiciosReservaException {
		try{
			return reservaDAO.graficarMenosUsados();
		} catch (PersistenceException e) {
			throw new ServiciosReservaException("Error al consultar reserva" , e);
		}	
	}
}


