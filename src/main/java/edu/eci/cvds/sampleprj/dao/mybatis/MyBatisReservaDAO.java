package edu.eci.cvds.sampleprj.dao.mybatis;

import edu.eci.cvds.sampleprj.dao.ReservaDAO;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.google.inject.Inject;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.sampleprj.dao.ReservaDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ReservaMapper;
import edu.eci.cvds.samples.entities.Reserva;

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

}
