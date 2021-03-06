package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.List;
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

	@Override
	public void removeRecurso(long idRecurso) throws PersistenceException{
		try{
			recursoMapper.eliminarRecurso(idRecurso);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al eliminar recurso "+idRecurso, e);
		} 
		
	}
	
}
