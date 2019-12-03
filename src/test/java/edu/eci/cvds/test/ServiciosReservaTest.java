package edu.eci.cvds.test;

import javax.validation.constraints.Null;

import com.google.inject.Inject;

import org.junit.Before;
import org.junit.After;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ServiciosReservaTest{
    
	@Inject
    ServiciosReserva serviciosReserva;
    public ServiciosReservaTest(){
        
    }

    @Before
    public void setUp(){
        serviciosReserva = ServiciosReservaFactory.getInstance().getServiciosReservaTesting();  
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
            e.printStackTrace();
        }
		Assert.assertTrue(r);
    }
	
	@Test
    public void deberiaAgregarRecurso(){
		boolean r = false;
		Tipo t;
		Recurso rec;
        try{
			t = new Tipo(1, "prueba", "prueba");
			serviciosReserva.agregarTipo(t);
			System.out.println(serviciosReserva.consultarRecursos());
			rec = new Recurso((long) 2, "prueba", "prueba", 1, true, null, t);
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
		Tipo t = new Tipo(2000, "prueba", "prueba");
		Recurso rec = new Recurso((long) 3, "prueba", "prueba", 1, true, null, t);
        try{
			serviciosReserva.agregarRecurso(rec);
        }
        catch (ServiciosReservaException e){
            r = true;
        }
		Assert.assertTrue(r);
    }
	
	/*
	@Test
    public void deberiaEstarDisponibleUnRecursoRecienIngresado(){
		boolean r = false;
		try{
			Tipo t = new Tipo(1, "prueba", "prueba");
			Recurso rec = new Recurso((long) 1, "prueba", "prueba", 1, true, null, t);
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
	}
	
	@Test
	public void prueba(){
		try{
			/**SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = formatter.parse("2019-11-14");
			System.out.println(serviciosReserva.consultarFranja(date, 1810, 10));
			System.out.println(serviciosReserva.consultarUsuario("0000001"));
			System.out.println(serviciosReserva.consultarRecurso((long) 1));

			//serviciosReserva.insertarReservaDias("2019-11-29", 1000, 100, "0000001", (long) 1, "2019-12-7", 3);
			System.out.println(serviciosReserva.consultarReservasRecurso((long) 2 ));
			serviciosReserva.insertarReserva("2019-12-30", 1300, 100, "0000001", (long) 4);
		}
		catch (ServiciosReservaException e){
			e.printStackTrace();
			System.out.println("fracaso");
        }
		/**catch (ParseException e) {
            e.printStackTrace();
        }
	}
	**/
	/*
	@Test
	public void pruebaConsultarReservasUsuario(){
		try{
			List<Reserva> resUsu= serviciosReserva.consultarReservasUsuario("0000001");
			System.out.println(resUsu);
			//serviciosReserva.insertarReserva("2019-11-30", 1300, 100, "0000001", (long) 1);
		}
		catch (ServiciosReservaException e){
			e.printStackTrace();
			System.out.println("fracaso");
        }
	}
	**/
}