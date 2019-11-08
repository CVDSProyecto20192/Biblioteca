package edu.eci.cvds;

import javax.validation.constraints.Null;

import com.google.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import edu.eci.cvds.samples.entities.Cargo;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Reserva;
import edu.eci.cvds.samples.entities.Tipo;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ServiciosReserva;
import edu.eci.cvds.samples.services.ServiciosReservaFactory;
import edu.eci.cvds.exceptions.ServiciosReservaException;
import org.junit.Assert;
public class ServiciosReservaTest{
    
	@Inject
    ServiciosReserva serviciosReserva;
    public ServiciosReservaTest(){
        
    }

    @Before
    public void setUp(){
        serviciosReserva = ServiciosReservaFactory.getServiciosReservaTesting();
    }

    @Test
    public void deberiaInsertarTipo(){
		boolean r = false;
		Tipo t;
        try{
			t = new Tipo(1, "prueba", "prueba");
            serviciosReserva.agregarTipo(t);
			t = serviciosReserva.consultarTipo(t.getId());
			if ( t != null){
				r = true;
			}
        }
        catch (ServiciosReservaException e){
            r = false;
        }
		Assert.assertTrue(r);
    }
	
	@Test
    public void noDeberiaInsertarDosTiposConElMismoId(){
		boolean r = true;
		Tipo t;
        try{
			t = new Tipo(2, "prueba", "prueba");
            serviciosReserva.agregarTipo(t);
        }
        catch (ServiciosReservaException e){
			System.out.println("entroTest");
            r = false;
        }
		boolean f = false;
		try{
			t = new Tipo(2, "prueba2", "prueba2");
            serviciosReserva.agregarTipo(t);
        }
        catch (ServiciosReservaException e){
			f = true;
        }  
		Assert.assertTrue(f);
		Assert.assertTrue(r);
    }
	
	@Test
    public void deberiaAgregarRecurso(){
		boolean r = false;
		Tipo t;
		Recurso rec;
        try{
			t = new Tipo(3, "prueba", "prueba");
			serviciosReserva.agregarTipo(t);
			rec = new Recurso((long) 1, "prueba", "prueba", 1, true, 5, t);
			serviciosReserva.agregarRecurso(rec);
			rec = serviciosReserva.consultarRecurso(rec.getId());
			if ( rec != null){
				r = true;
			}
        }
        catch (ServiciosReservaException e){
            r = false;
        }
		Assert.assertTrue(r);
    }
	
	@Test
    public void noAgregarDosRecursosConElMismoId(){
		boolean r = false;
		Tipo t = new Tipo(4, "prueba", "prueba");
		Recurso rec = new Recurso((long) 2, "prueba", "prueba", 1, true, 5, t);
        try{
			serviciosReserva.agregarTipo(t);
			serviciosReserva.agregarRecurso(rec);
			rec = serviciosReserva.consultarRecurso(rec.getId());
			if ( rec != null){
				r = true;
			}
        }
        catch (ServiciosReservaException e){
            r = false;
        }
		Assert.assertTrue(r);
		r = false;
        try{
			rec = new Recurso((long) 2, "prueba2", "prueba2", 3, true, 2, t);
			serviciosReserva.agregarRecurso(rec);
        }
        catch (ServiciosReservaException e){
            r = true;
        }
		Assert.assertTrue(r);
    }


	@Test
    public void noDeberiaAgregarUnRecursoQueNoPoseeUnTipoRegistrado(){
		boolean r = false;
		Tipo t = new Tipo(5, "prueba", "prueba");
		Recurso rec = new Recurso((long) 3, "prueba", "prueba", 1, true, 5, t);
        try{
			serviciosReserva.agregarRecurso(rec);
        }
        catch (ServiciosReservaException e){
            r = true;
        }
		Assert.assertTrue(r);
    }

    
}