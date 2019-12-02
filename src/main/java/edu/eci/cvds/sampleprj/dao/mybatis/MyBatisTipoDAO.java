package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.List;

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
		if(t==null) throw new PersistenceException("Error al consultar tipo "+ id+" - No existe");
		else return t; 
	}

	@Override
	public List<Tipo> loadAll() throws PersistenceException {
		try{
			return tipoMapper.consultarTipos();
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar tipos", e);
		}
	}

	@Override
	public void addTipo(Tipo tipo) throws PersistenceException {
		try {
			tipoMapper.insertarTipo(tipo);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("No fue posible agregar el tipo", e);
		}
		
		
	}

	@Override
	public int loadIdTipo(Tipo tipo) throws PersistenceException {
		try {
			return tipoMapper.consutarIdTipo(tipo);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("No fue posible consultar el id del tipo", e);
		}
	}

}
