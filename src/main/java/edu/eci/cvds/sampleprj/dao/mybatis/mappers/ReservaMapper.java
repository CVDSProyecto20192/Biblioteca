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

	public List<Reserva> frecuenteXTipo();

	public List<Reserva> recursosFrecuentesXHorario();
	
	public void cancelarReserva(@Param("reserva")Reserva reserva);
	
	public void cancelarReservas(@Param("reserva")Reserva reserva);
	
	public void cancelarReservasHastaFecha(@Param("reserva")Reserva reserva, @Param("limite")Date f);

	public List<Reserva> menosFrecuentesXFecha();

	public List<Reserva> recursosMenosFrecuentesXHorario();

	public List<Reserva> menosFrecuenteXTipo();

	public List<Reserva> horariosMasXFecha();

	public List<Reserva> horarioMasFrecuente();

	public List<Reserva> horariosMasXTipo();

	public List<Reserva> horarioMenosFrecuente();

	public List<Reserva> horariosMenosXFecha();

	public List<Reserva> horariosMenosXTipo();

}