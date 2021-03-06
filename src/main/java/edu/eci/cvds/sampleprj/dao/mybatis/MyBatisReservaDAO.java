package edu.eci.cvds.sampleprj.dao.mybatis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.sampleprj.dao.ReservaDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ReservaMapper;
import edu.eci.cvds.samples.entities.Reserva;

public class MyBatisReservaDAO implements ReservaDAO {
	
	@Inject
	private ReservaMapper reservaMapper;  

	@Override
	public Reserva ConsultarReserva(long codigo) throws PersistenceException{
		try{
			return reservaMapper.consultarReserva(codigo);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Reserva", e);
		}  
	}
	
	@Override
	public List<Reserva> loadAll() throws PersistenceException {
		try{
			return reservaMapper.consultarReservas();
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Reservas", e);
		}  
	}
	
	@Override
	public List<Reserva> consultarReservasRecurso(long RecursoId) throws PersistenceException {
		try{
			return reservaMapper.consultarReservasRecurso(RecursoId);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Reservas", e);
		}  
	}
	
	@Override
	public List<Reserva> consultarReservasGrupo(long grupo) throws PersistenceException {
		try{
			return reservaMapper.consultarReservasGrupo(grupo);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Reservas por grupo", e);
		}  
	}

	@Override
	public List<Reserva> consultarReservasUsuario(String usuario) throws PersistenceException {
		try{
			return reservaMapper.consultarReservasUsuario(usuario);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar carnet del usuario", e);
		}  
	}

	@Override
	public List<Reserva> consultarReservasUsuarioNoActivas(String usuario) throws PersistenceException {
		try{
			return reservaMapper.consultarReservasUsuarioNoActivas(usuario);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar carnet del usuario", e);
		}  
	}
	
	@Override
	public long consultarGrupo() throws PersistenceException {
		try{
			return reservaMapper.consultarIdGrupo();
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar id del grupo", e);
		}  
	}
	
	@Override
	public Reserva consultarFranja(Date fecha, int hora, int duracion,long recurso) throws PersistenceException {
		Reserva r = null;
		try{
			r = reservaMapper.consultarFranja(fecha, hora, duracion, recurso);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar franja", e);
		}  	
		return r;
	}
	
	@Override
	public void insertarReserva(Reserva reserva) throws PersistenceException {
		try{
			if (consultarFecha(reserva.getFecha(), reserva.getHora())){
				reservaMapper.insertarReserva(reserva);
			}
			else{
				throw new PersistenceException("La reserva debe hacerse para despues de la hora actual");
			}
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al insertar reserva", e);
		}  	
	}
	
	@Override
	public List<Date> getFechas(String fecha, String fechaFin,int periodicidad){
		List<Date> fechas = new ArrayList<Date>();
		try{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date inicio = formatter.parse(fecha);
			Date fin = formatter.parse(fechaFin);
			Calendar calendar = Calendar.getInstance();
			while (inicio.compareTo(fin) <= 0){
				fechas.add(inicio);
				calendar.setTime(inicio);
				calendar.add(Calendar.DAY_OF_YEAR, periodicidad);
				inicio = calendar.getTime();
			}
		}catch (ParseException e) {
            e.printStackTrace();
        }
		return fechas;
	}
	
	public boolean consultarFecha(Date fecha, int hora){
		boolean flag = true;
		int h = hora/100;
		int m = hora % 100;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.HOUR, h);
		calendar.add(Calendar.MINUTE, m);
		Date fecha2 = calendar.getTime();
		Date actual = new Date();
		if (fecha2.compareTo(actual) < 0){
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Reserva> recursosFrecuentes() throws PersistenceException {
		try{
			return reservaMapper.recursosFrecuentes();
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Reservas", e);
		}  
	}

	@Override
	public List<Reserva> frecuenteXHorario() throws PersistenceException{
		try{
			return reservaMapper.frecuenteXHorario();
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Reservas", e);
		}  
	}

	@Override
	public List<Reserva> recursosMasFrecuentes() throws PersistenceException {
		try{
			return reservaMapper.recursosMasFrecuentes();
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Reservas", e);
		}  
	}

	@Override
	public List<Reserva> masFrecuenteXHorario() throws PersistenceException {
		try{
			return reservaMapper.masFrecuenteXHorario();
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Reservas", e);
		}  
	}

	@Override
	public List<Reserva> frecuenteXTipo() throws PersistenceException {
		try{
			return reservaMapper.frecuenteXTipo();
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Reservas", e);
		}  
	}

	@Override
	public List<Reserva> recursosFrecuentesXHorario() throws PersistenceException {
		try{
			return reservaMapper.recursosFrecuentesXHorario();
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Reservas", e);
		}  
	}

	@Override
	public List<Reserva> menosFrecuentesXFecha() throws PersistenceException {
		try{
			return reservaMapper.menosFrecuentesXFecha();
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Reservas", e);
		}  
	}

	@Override
	public List<Reserva> recursosMenosFrecuentesXHorario() throws PersistenceException {
		try{
			return reservaMapper.recursosMenosFrecuentesXHorario();
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Reservas", e);
		}  
	}

	@Override
	public List<Reserva> menosFrecuenteXTipo() throws PersistenceException {
		try{
			return reservaMapper.menosFrecuenteXTipo();
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Reservas", e);
		}  
	}

	@Override
	public List<Reserva> horariosMasXFecha() throws PersistenceException {
		try{
			return reservaMapper.horariosMasXFecha();
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Reservas", e);
		}  
	}

	@Override
	public List<Reserva> horarioMasFrecuente() throws PersistenceException {
		try{
			return reservaMapper.horarioMasFrecuente();
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Reservas", e);
		}  
	}

	@Override
	public List<Reserva> horariosMasXTipo() throws PersistenceException {
		try{
			return reservaMapper.horariosMasXTipo();
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Reservas", e);
		}  
	}

	@Override
	public List<Reserva> horarioMenosFrecuente() throws PersistenceException {
		try{
			return reservaMapper.horarioMenosFrecuente();
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Reservas", e);
		}  
	}

	@Override
	public List<Reserva> horariosMenosXFecha() throws PersistenceException {
		try{
			return reservaMapper.horariosMenosXFecha();
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Reservas", e);
		} 
	}

	@Override
	public List<Reserva> horariosMenosXTipo() throws PersistenceException {
		try{
			return reservaMapper.horariosMenosXTipo();
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Reservas", e);
		} 
	}

	@Override
	public void cancelarReserva(Reserva r) throws PersistenceException{
		try{
			reservaMapper.cancelarReserva(r);
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al cancelar Reserva", e);
		}  
	}
	
	@Override
	public void cancelarReservas(Reserva r) throws PersistenceException{
		try{
			reservaMapper.cancelarReservas(r);
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al cancelar las Reservas", e);
		}  
	}
	
	@Override
	public void cancelarReservasHastaFecha(Reserva r, Date f) throws PersistenceException{
		try{
			reservaMapper.cancelarReservasHastaFecha(r, f);
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al cancelar las Reservas", e);
		}  
	}

	@Override
	public List<Reserva> graficoMasUsados() throws PersistenceException {
		try{
			return reservaMapper.graficoMasUsados();
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Reservas", e);
		} 
	}

	@Override
	public List<Reserva> graficarMenosUsados() throws PersistenceException {
		try{
			return reservaMapper.graficarMenosUsados();
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Reservas", e);
		} 
	}

}