package edu.eci.cvds.samples.services;

import java.util.List;
import edu.eci.cvds.samples.entities.Usuario;

public interface ServiciosReserva {

	public Usuario consultarUsuario(String carnet);

	public List<Usuario>consultarUsuarios();

}
