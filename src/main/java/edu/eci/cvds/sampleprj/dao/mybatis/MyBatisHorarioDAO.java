package edu.eci.cvds.sampleprj.dao.mybatis;

import java.sql.Date;
import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.sampleprj.dao.HorarioDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.HorarioMapper;
import edu.eci.cvds.samples.entities.Horario;

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
	public void addHorario(Horario h) throws PersistenceException {
		try{
			horarioMapper.insertarHorario(h);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al insertar Horario", e);
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
	public void updateHoras(long idHorario, String dia, List<Date> horas) throws PersistenceException{
		try{
			horarioMapper.actualizarHoras(idHorario, dia, horas);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al actualizar Horario", e);
		}
	}

}
