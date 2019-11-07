package edu.eci.cvds.exceptions;

public class ServiciosReservaException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiciosReservaException(String msg) {
        super(msg);
    }
	
	public ServiciosReservaException(String msg, Exception e) {
        super(msg,e);
    
    }

}