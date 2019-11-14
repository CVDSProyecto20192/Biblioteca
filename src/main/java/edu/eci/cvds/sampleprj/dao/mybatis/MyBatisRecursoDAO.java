package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.google.inject.Inject;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.sampleprj.dao.RecursoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.RecursoMapper;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Tipo;

public class MyBatisRecursoDAO implements RecursoDAO{

	@Inject
	private RecursoMapper recursoMapper;   

	@Override
	public Recurso load(long id) throws PersistenceException {
		Recurso r=recursoMapper.consultarRecurso(id);
		if(r==null) throw new PersistenceException("Error al consultar recurso "+ id+
		" - No existe");
		else return r;   
	}

	@Override
	public List<Recurso> loadAll() throws PersistenceException {
		try{
			return recursoMapper.consultarRecursos();
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Recursos", e);
		}  
	}
	
	@Override
	public List<Recurso> loadActivos() throws PersistenceException {
		try{
			return recursoMapper.consultarRecursosActivos();
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar Recursos activos", e);
		}  
	}
	
	@Override
	public void addRecurso(Recurso r) throws PersistenceException {
		try{
			recursoMapper.insertarRecurso(r);
			long id=recursoMapper.consultarIdRecurso(r.getNombre(),r.getTipo(), r.getUbicacion());
			r.setId(id);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al insertar Recursos", e);
		}  
	}
	
	@Override
	public void updateIdHorario(long id_recurso, long id_horario) throws PersistenceException {
		try{
			recursoMapper.actualizarIdHorario(id_recurso,id_horario);

		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al actualizar horario del ecurso", e);
		}  
	}

	@Override
	public long loadIdHorario(long id) throws PersistenceException {
		try{
			return recursoMapper.consultarIdHorario(id);

		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al cargar id del horario", e);
		}  
	}
	
	@Override
	public long loadIdRecurso(String nombre, Tipo t, String ubicacion) throws PersistenceException {
		try{
			return recursoMapper.consultarIdRecurso(nombre, t, ubicacion);
			
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar recurso", e);
		} 
	}

	@Override
	public boolean loadDispRecurso(long id) throws PersistenceException {
		try{
			return recursoMapper.consultarDisponibilidadRecurso(id);
			
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar disponibilidad del recurso "+id, e);
		} 
	}

	@Override
	public void updateDispRecurso(long id, boolean b) throws PersistenceException {
		try{
			recursoMapper.actDisponibilidadRecurso(id, b);
			
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al actualizar disponibilidad del recurso "+id, e);
		} 
		
	}

	@Override
	public long loadLastId() throws PersistenceException {
		try{
			return recursoMapper.consultarUltimoId();
			
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar id del último recurso ", e);
		} 
	}

	
	
}
