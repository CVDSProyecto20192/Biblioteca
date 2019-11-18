package edu.eci.cvds.sampleprj.dao.mybatis;

import edu.eci.cvds.sampleprj.dao.ReservaDAO;
import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Param;

import com.google.inject.Inject;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.sampleprj.dao.ReservaDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ReservaMapper;
import edu.eci.cvds.samples.entities.Reserva;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyBatisReservaDAO implements ReservaDAO {
	
	@Inject
	private ReservaMapper reservaMapper;  
	
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
	public Reserva consultarFranja(Date fecha, int hora, int duracion) throws PersistenceException {
		Reserva r = null;
		try{
			r = reservaMapper.consultarFranja(fecha, hora, duracion);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar franja", e);
		}  	
		return r;
	}
	
	@Override
	public void insertarReserva(Reserva reserva) throws PersistenceException {
		try{
			reservaMapper.insertarReserva(reserva);
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
	

}
