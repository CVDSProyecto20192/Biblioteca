package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Cargo;

public interface CargoMapper {
	
	public Cargo consultarCargo(@Param("id_cargo")int idCargo);
	
	public List<Cargo> consultarCargos();
	
	public void insertarCargo(@Param("cargo")Cargo cargo);
	
	public int consutarIdCargo(@Param("cargo")Cargo cargo);

}
