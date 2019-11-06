package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Cargo;

public interface CargoMapper {
	
	public void insertarCargo(@Param("cargo")Cargo cargo);

}
