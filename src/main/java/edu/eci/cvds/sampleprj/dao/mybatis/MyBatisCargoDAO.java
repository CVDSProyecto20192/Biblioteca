package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.sampleprj.dao.CargoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.CargoMapper;
import edu.eci.cvds.samples.entities.Cargo;

public class MyBatisCargoDAO implements CargoDAO {
	
	@Inject
	private CargoMapper cargoMapper;

	@Override
	public Cargo loadCargo(int idCargo) throws PersistenceException {
		try {
			return cargoMapper.consultarCargo(idCargo);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("No fue posible encontrar el cargo: "+idCargo);
		}
	}

	@Override
	public List<Cargo> loadCargos() throws PersistenceException {
		try {
			return cargoMapper.consultarCargos();
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
			e.printStackTrace();
			throw new PersistenceException("No fue listar los cargos");
			
		}
	}
	
	@Override
	public void addCargo(Cargo cargo) throws PersistenceException {
		try {
			cargoMapper.insertarCargo(cargo);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("No fue posible agregar el cargo");
		}
		
	}

	@Override
	public int loadIdCargo(Cargo cargo) throws PersistenceException {
		try {
			return cargoMapper.consutarIdCargo(cargo);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("No fue consultar el id del cargo");
		}
	}

}
