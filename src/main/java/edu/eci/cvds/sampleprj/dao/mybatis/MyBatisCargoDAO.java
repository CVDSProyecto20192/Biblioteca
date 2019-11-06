package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.sampleprj.dao.CargoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.CargoMapper;
import edu.eci.cvds.samples.entities.Cargo;

public class MyBatisCargoDAO implements CargoDAO {
	
	@Inject
	private CargoMapper cargoMapper;

	@Override
	public void addCargo(Cargo cargo) throws PersistenceException {
		try {
			cargoMapper.insertarCargo(cargo);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("No fue posible agregar el cargo");
		}
		
	}
	
}
