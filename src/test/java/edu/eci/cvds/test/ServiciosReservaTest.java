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
			rec = new Recurso((long) 1, "prueba", "prueba", 1, true, null, t);
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
    public void noDeberiaAgregarRecursoConLaMismaUbicacionYNombre(){
		boolean r = false;
		Tipo t;
		Recurso rec;
        try{
			t = new Tipo(1, "prueba", "prueba");
			serviciosReserva.agregarTipo(t);
			rec = new Recurso((long) 1, "prueba5", "prueba4", 1, true, null, t);
			serviciosReserva.agregarRecurso(rec);
			rec = new Recurso((long) 1, "prueba5", "prueba4", 1, true, null, t);
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
	
	
	@Test
    public void deberiaEstarDisponibleUnRecursoRecienIngresado(){
		boolean r = false;
		try{
			Tipo t = new Tipo(1, "prueba", "prueba");
			Recurso rec = new Recurso((long) 1, "prueba2", "prueba2", 1, true, null, t);
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
			Tipo t = new Tipo(1, "prueba", "prueba");
			Recurso rec = new Recurso((long) 1, "prueba3", "prueba3", 1, true, null, t);
			serviciosReserva.agregarTipo(t);
			serviciosReserva.agregarRecurso(rec);
			serviciosReserva.cambiarDisponibilidadRecurso((long) 1, false);
			r = serviciosReserva.consultarDisponibilidadRecurso((long) 1);
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
	public void deberiaGenerarIdRecursoAscendente(){
		boolean r = false;
		try{
			Tipo t = new Tipo(1, "prueba", "prueba");
			serviciosReserva.agregarTipo(t);
			Recurso rec = new Recurso((long) 1, "prueba7", "prueba7", 1, true, null, t);
			long ini = serviciosReserva.consultarIdUltimoRecurso();
			serviciosReserva.agregarRecurso(rec);
			rec = new Recurso((long) 1, "prueba8", "prueba8", 1, true, null, t);
			serviciosReserva.agregarRecurso(rec);
			long fin = serviciosReserva.consultarIdUltimoRecurso();
			if (fin > ini){
				r = true;
			}
		}catch (ServiciosReservaException e){
            r = false;
        }
		Assert.assertTrue(r);
	}
	
	
	@Test
	public void deberiaInsertarReserva(){
		boolean r = true;
		try{
			Tipo t = new Tipo(1, "prueba", "prueba");
			serviciosReserva.agregarTipo(t);
			Recurso rec = new Recurso((long) 1, "prueba6", "prueba6", 1, true, null, t);
			serviciosReserva.agregarRecurso(rec);
			serviciosReserva.insertarReserva("2020-04-30", 1000, 159, "000", serviciosReserva.consultarIdUltimoRecurso());	
		}
		catch (ServiciosReservaException e){
            r = false;
        }
		Assert.assertTrue(r);	
	}
	
	@Test
	public void noDeberiaInsertarReserva(){
		boolean f = false;
		boolean r = false;
		try{
			Tipo t = new Tipo(1, "prueba", "prueba");
			serviciosReserva.agregarTipo(t);
			Recurso rec = new Recurso((long) 1, "prueba9", "prueba9", 1, true, null, t);
			serviciosReserva.agregarRecurso(rec);
			serviciosReserva.insertarReserva("2020-04-29", 1300, 159, "000", serviciosReserva.consultarIdUltimoRecurso());
			f = true;
			serviciosReserva.insertarReserva("2020-04-29", 1359, 159, "000", serviciosReserva.consultarIdUltimoRecurso());
		}
		catch (ServiciosReservaException e){
            r = true;
        }
		Assert.assertTrue(r);	
		Assert.assertTrue(f);
	}
	
	@Test
	public void noDeberiaInsertarReservaConMasDeDosHorasDeDuracion(){
		boolean r = false;
		try{
			Tipo t = new Tipo(1, "prueba", "prueba");
			serviciosReserva.agregarTipo(t);
			Recurso rec = new Recurso((long) 1, "prueba10", "prueba10", 1, true, null, t);
			serviciosReserva.agregarRecurso(rec);
			serviciosReserva.insertarReserva("2020-04-28", 1300, 201, "000", serviciosReserva.consultarIdUltimoRecurso());
		}
		catch (ServiciosReservaException e){
            r = true;
        }
		Assert.assertTrue(r);	
	}
	
	@Test
	public void noDeberiaInsertarReservaQueExcedaElHorarioInstitucional(){
		boolean r = false;
		try{
			Tipo t = new Tipo(1, "prueba", "prueba");
			serviciosReserva.agregarTipo(t);
			Recurso rec = new Recurso((long) 1, "prueba11", "prueba11", 1, true, null, t);
			serviciosReserva.agregarRecurso(rec);
			serviciosReserva.insertarReserva("2020-04-28", 1900, 1, "000", serviciosReserva.consultarIdUltimoRecurso());
		}
		catch (ServiciosReservaException e){
            r = true;
        }
		Assert.assertTrue(r);	
	}
	
	@Test
	public void noDeberiaInsertarReservaQueSeaAntesDelHorarioInstitucional(){
		boolean r = false;
		try{
			Tipo t = new Tipo(1, "prueba", "prueba");
			serviciosReserva.agregarTipo(t);
			Recurso rec = new Recurso((long) 1, "prueba12", "prueba12", 1, true, null, t);
			serviciosReserva.agregarRecurso(rec);
			serviciosReserva.insertarReserva("2020-04-28", 659, 100, "000", serviciosReserva.consultarIdUltimoRecurso());
		}
		catch (ServiciosReservaException e){
            r = true;
        }
		Assert.assertTrue(r);	
	}
	
	@Test
	public void noDeberiaInsertarReservaUnDomingo(){
		boolean r = false;
		try{
			Tipo t = new Tipo(1, "prueba", "prueba");
			serviciosReserva.agregarTipo(t);
			Recurso rec = new Recurso((long) 1, "prueba13", "prueba13", 1, true, null, t);
			serviciosReserva.agregarRecurso(rec);
			serviciosReserva.insertarReserva("2019-12-29", 1000, 100, "000", serviciosReserva.consultarIdUltimoRecurso());
		}
		catch (ServiciosReservaException e){
            r = true;
        }
		Assert.assertTrue(r);	
	}
	
	@Test
	public void noDeberiaInsertarReservaUnSabadaDespuesDeLaUna(){
		boolean r = false;
		try{
			Tipo t = new Tipo(1, "prueba", "prueba");
			serviciosReserva.agregarTipo(t);
			Recurso rec = new Recurso((long) 1, "prueba14", "prueba14", 1, true, null, t);
			serviciosReserva.agregarRecurso(rec);
			serviciosReserva.insertarReserva("2019-12-28", 1200, 101, "000", serviciosReserva.consultarIdUltimoRecurso());
		}
		catch (ServiciosReservaException e){
            r = true;
        }
		Assert.assertTrue(r);	
	}
	
	@Test
	public void deberiaInsertarReservasPeriodicasSinIncluirDomingosNiSabadosDespuesDeLaUna(){
		boolean r = false;
		try{
			Tipo t = new Tipo(1, "prueba", "prueba");
			serviciosReserva.agregarTipo(t);
			Recurso rec = new Recurso((long) 1, "prueba15", "prueba15", 1, true, null, t);
			serviciosReserva.agregarRecurso(rec);
			serviciosReserva.insertarReservaDias("2020-01-01", 1200, 101, "000", serviciosReserva.consultarIdUltimoRecurso(), "2020-01-31", 1);
			List<Reserva> reservas = serviciosReserva.consultarReservasGrupo((long) 1);
			if (reservas.size() == 23){
				r = true;
			}
		}
		catch (ServiciosReservaException e){
            r = false;
        }
		Assert.assertTrue(r);	
	}
	
	@Test
	public void noDeberiaInsertarReservasPeriodicasSiAlgunaSeCruzaConAlgunaOtraReserva(){
		boolean f = false;
		boolean r = false;
		try{
			Tipo t = new Tipo(1, "prueba", "prueba");
			serviciosReserva.agregarTipo(t);
			Recurso rec = new Recurso((long) 1, "prueba16", "prueba16", 1, true, null, t);
			serviciosReserva.agregarRecurso(rec);
			serviciosReserva.insertarReserva("2020-02-03", 1200, 101, "000", serviciosReserva.consultarIdUltimoRecurso());
			f = true;
			serviciosReserva.insertarReservaDias("2020-02-01", 1200, 101, "000", serviciosReserva.consultarIdUltimoRecurso(), "2020-02-28", 1);
			
		}
		catch (ServiciosReservaException e){
            r = true;
        }
		Assert.assertTrue(f);	
		Assert.assertTrue(r);	
	}
	

	/*
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
	
	
}