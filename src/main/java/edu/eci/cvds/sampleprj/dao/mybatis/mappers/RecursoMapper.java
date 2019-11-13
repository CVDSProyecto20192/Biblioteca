package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Tipo;

public interface RecursoMapper {
	
	public Recurso consultarRecurso(@Param("id_recurso")long idRecurso); 
    
    /**
     * Consultar todos los recursos
     * @return 
     */
    public List<Recurso> consultarRecursos();

    public void insertarRecurso(@Param("recurso")Recurso r);
    
    public void actualizarIdHorario(@Param("id_recurso") long id_recurso,@Param("id_horario") long id_horario);
   
    public long consultarIdHorario(@Param("id_rec")long id_recurso);            

    public long consultarIdRecurso(@Param("nom_rec")String nombre,@Param("tipo") Tipo tipo,@Param("ubi_rec")String ubicacion);            

    public boolean consultarDisponibilidadRecurso(@Param("id_rec")long id);
    
    public void actDisponibilidadRecurso(@Param("id_rec")long id, @Param("disp")boolean b);

	public long consultarUltimoId();
}
