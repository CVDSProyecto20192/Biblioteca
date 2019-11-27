package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.sampleprj.dao.HorarioDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.HorarioMapper;
import edu.eci.cvds.samples.entities.Hora;
import edu.eci.cvds.samples.entities.Horario;
import edu.eci.cvds.samples.entities.Recurso;

public class MyBatisHorarioDAO implements HorarioDAO{
	
	@Inject
	private HorarioMapper horarioMapper;

	@Override
	public Horario load(long id, String dia) throws PersistenceException {
		Horario h=horarioMapper.consultarHorarioDia(id, dia);
		if(h==null) throw new PersistenceException("Error al consultar el horario "+ id+ " - No existe");
		else return h;  
	}

	@Override
	public List<Horario> loadAllDia(long id) throws PersistenceException {
		try{
			System.out.println("My batis horario");
			System.out.println(id);
			return horarioMapper.consultarHorarioDias(id);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Horarios "+id, e);
		} 
	}

	@Override
	public List<Horario> loadAll() throws PersistenceException {
		try{
			return horarioMapper.consultarHorarios();
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Horarios ", e);
		}
	}


	
	@Override
	public void addHorario(Horario h, long r) throws PersistenceException {
		try{
			horarioMapper.insertarHorario(h, r);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al insertar Horario", e);
		}
		
	}

	@Override
	public void addHora(Horario h, Hora hs) throws PersistenceException {
		try{
			horarioMapper.insertarHora(h, hs);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al insertar Hora", e);
		}
		
	}
	
	@Override
	public long loadIdHora(Hora h, Horario hs) throws PersistenceException {
		try{
			return horarioMapper.consultarIdHora(h, hs);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar hora", e);
		}
	}


	@Override
	public void updateTiempoHora(long idHora, Date hora) throws PersistenceException {
		try{
			horarioMapper.actualizarTiempoHora(idHora, hora);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar hora", e);
		}		
	}
	
	@Override
	public boolean loadDispHora(long idHora) throws PersistenceException {
		try{
			return horarioMapper.consultarDispHora(idHora);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar hora", e);
		}
	}

	@Override
	public void updateDispHora(long idHora, boolean b) throws PersistenceException {
		try{
			horarioMapper.actualizarDispHora(idHora,b);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al actualizar diaponibilidad de hora", e);
		}
	}

	
	@Override
	public long loadLastId() throws PersistenceException {
		try{
			return horarioMapper.consultarUltimoId();
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar id del último Horario", e);
		}
	}

	@Override
	public void removeHora(Horario h,long idHora) throws PersistenceException {
		try{
			horarioMapper.eliminarHora(idHora);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al eliminar la hora", e);
		}
		
	}
	
}
