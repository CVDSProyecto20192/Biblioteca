package edu.eci.cvds.samples.services;

import java.util.List;

import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Tipo;
import edu.eci.cvds.samples.entities.Usuario;

public interface ServiciosReserva {

	public Usuario consultarUsuario(String carnet);

	public List<Usuario>consultarUsuarios();

	public Recurso consultarRecurso(long id);
	
	public List<Recurso> consultarRecursos();
	
	public List<Recurso> consultarRecursosDisponibles();
	
	public void bloquearRecurso(Recurso r);
	
	public void agregarRecurso(Recurso r);

	public Tipo consultarTipo(int tipoId);

}
