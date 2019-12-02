package edu.eci.cvds.sampleprj.dao.mybatis.mappers;
import edu.eci.cvds.samples.entities.Reserva;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
public interface ReservaMapper {
	
	/**
     * Consultar todas las reservas
     * @return 
     */
	 
	public Reserva consultarReserva(@Param("codigo") long codigo);
	
	public List<Reserva> consultarReservas();
	
	public List<Reserva> consultarReservasRecurso(@Param("recursoId")long recursoId);
	
	public List<Reserva> consultarReservasGrupo(@Param("group")long grupo);

	public List<Reserva> consultarReservasUsuario(@Param("user")String usuario);
	
	public Reserva consultarFranja(@Param("fecha")Date fecha , @Param("hora")int hora, @Param("duracion")int duracion,@Param("recurso")long recurso);
	
	public void insertarReserva(@Param("reserva")Reserva reserva);
	
	public long consultarIdGrupo();

	public List<Reserva> recursosFrecuentes();

	public List<Reserva> frecuenteXHorario();

	public List<Reserva> recursosMasFrecuentes();

	public List<Reserva> masFrecuenteXHorario();

}