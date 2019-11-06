package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.sampleprj.dao.RecursoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.RecursoMapper;
import edu.eci.cvds.samples.entities.Recurso;

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
	public void addRecurso(Recurso r) throws PersistenceException {
		try{
			recursoMapper.insertarRecurso(r);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al insertar Recursos", e);
		}  
	}

	
	
}
