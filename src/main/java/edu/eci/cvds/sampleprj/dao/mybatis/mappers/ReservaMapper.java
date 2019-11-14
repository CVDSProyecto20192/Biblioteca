package edu.eci.cvds.sampleprj.dao.mybatis.mappers;
import edu.eci.cvds.samples.entities.Reserva;
import java.util.List;
public interface ReservaMapper {
	
	/**
     * Consultar todas las reservas
     * @return 
     */
	public List<Reserva> consultarReservas();

}
