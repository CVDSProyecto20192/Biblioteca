package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.sampleprj.dao.TipoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoMapper;
import edu.eci.cvds.samples.entities.Tipo;

public class MyBatisTipoDAO implements TipoDAO {

	@Inject
	private TipoMapper tipoMapper; 
	
	@Override
	public Tipo load(int id) throws PersistenceException {
		Tipo t=tipoMapper.consultarTipo(id);
		if(t==null) throw new PersistenceException("Error al consultar tipo "+ id+ " - No existe");
		else return t;   
	}
	
	@Override
	public void addTipo(Tipo t) throws PersistenceException {
		try{
			tipoMapper.insertarTipo(t);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al insertar el tipo", e);
		}  
	}
}
