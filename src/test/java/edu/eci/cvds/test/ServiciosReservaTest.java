package edu.eci.cvds.test;

import javax.validation.constraints.Null;

import com.google.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import edu.eci.cvds.samples.entities.Cargo;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Reserva;
import edu.eci.cvds.samples.entities.Tipo;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.entities.Reserva;
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
        serviciosReserva = ServiciosReservaFactory.getInstance().getServiciosReserva();        
    }
	/*
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
            e.printStackTrace();
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

	@Test
    public void deberiaEstarDisponibleUnRecursoRecienIngresado(){
		boolean r = false;
		try{
			Tipo t = new Tipo(6, "prueba", "prueba");
			Recurso rec = new Recurso((long) 1, "prueba", "prueba", 1, true, 5, t);
			serviciosReserva.agregarTipo(t);
			serviciosReserva.agregarRecurso(rec);
			r = serviciosReserva.consultarDisponibilidadRecurso((long) 1);
		}
		catch (ServiciosReservaException e){
            r = false;
        }
		Assert.assertTrue(r);	
	}
	
	@Test
    public void deberiaCambiarElEstadoDisponibleDeUnRecurso(){
		boolean r = true;
		try{
			Tipo t = new Tipo(7, "prueba", "prueba");
			Recurso rec = new Recurso((long) 3, "prueba", "prueba", 1, true, 5, t);
			serviciosReserva.agregarTipo(t);
			serviciosReserva.agregarRecurso(rec);
			serviciosReserva.cambiarDisponibilidadRecurso((long) 3, false);
			r = serviciosReserva.consultarDisponibilidadRecurso((long) 3);
		}
		
		catch (ServiciosReservaException e){
            r = true;
        }
		
		Assert.assertFalse(r);	
	}
	
	@Test
    public void noDeberiaCambiarElEstadoDisponibleDeUnRecursoQueNoExiste(){
		boolean r = false;
		try{
			serviciosReserva.cambiarDisponibilidadRecurso((long) 10000, false);
		}
		
		catch (ServiciosReservaException e){
            r = true;
        }
		
		Assert.assertTrue(r);	
	}*/
	
	@Test
	public void prueba(){
		try{
			System.out.println(serviciosReserva.consultarReservas());
		}
		catch (ServiciosReservaException e){
			e.printStackTrace();
			System.out.println("fracaso");
        }
	}
	
}